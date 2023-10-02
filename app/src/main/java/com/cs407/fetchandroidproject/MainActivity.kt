package com.cs407.fetchandroidproject

import android.os.Bundle
import android.util.Log
import android.widget.ExpandableListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    private lateinit var itemAdapter: ExpandableItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Prepare data for ExpandableItemAdapter
        lifecycleScope.launch {
            try {
                val items = fetchData()
                val groupedItems = items.filter { it.name != null && it.name.trim().isNotEmpty() }
                    .groupBy { it.listId }
                    .mapValues { (_, value) -> value.sortedBy { it.name } }

                // Sort the keys (list IDs) to sort the expandable lists
                val sortedHeaders = groupedItems.keys.toList().sorted()

                itemAdapter = ExpandableItemAdapter(this@MainActivity, sortedHeaders, groupedItems)

                val expandableListView: ExpandableListView = findViewById(R.id.expandableListView)
                expandableListView.setAdapter(itemAdapter)
            } catch (e: Exception) {
                Log.e("MainActivity", "Error: $e")
            }
        }
    }
    private suspend fun fetchData(): List<Item> = withContext(Dispatchers.IO) {
        val url = "https://fetch-hiring.s3.amazonaws.com/hiring.json"
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        client.newCall(request).execute().use { response ->
            val type = object : TypeToken<List<Item>>() {}.type
            return@use Gson().fromJson(response.body?.string(), type)
        }
    }
}

sealed class ViewItem {
    data class Header(val listId: Int) : ViewItem()
    data class Item(val item: com.cs407.fetchandroidproject.Item) : ViewItem()
}

