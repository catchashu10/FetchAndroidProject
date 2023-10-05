// Not being used anymore

//package com.cs407.fetchandroidproject
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.cs407.fetchandroidproject.R
//
//class ItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    var viewItems: List<ViewItem> = emptyList()
//
//    fun submitList(items: List<ViewItem>) {
//        viewItems = items
//        notifyDataSetChanged()
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return when (viewItems[position]) {
//            is ViewItem.Header -> TYPE_HEADER
//            is ViewItem.Item -> TYPE_ITEM
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return if (viewType == TYPE_HEADER) {
//            val view = LayoutInflater.from(parent.context).inflate(R.layout.header_view, parent, false)
//            HeaderViewHolder(view)
//        } else {
//            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
//            ItemViewHolder(view)
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when (val viewItem = viewItems[position]) {
//            is ViewItem.Header -> (holder as HeaderViewHolder).bind(viewItem)
//            is ViewItem.Item -> (holder as ItemViewHolder).bind(viewItem)
//        }
//    }
//
//    override fun getItemCount() = viewItems.size
//
//    companion object {
//        const val TYPE_HEADER = 0
//        const val TYPE_ITEM = 1
//    }
//
//    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        private val textView: TextView = view.findViewById(R.id.headerTextView)
//        fun bind(viewItem: ViewItem.Header) {
//            textView.text = "List ID: ${viewItem.listId}"
//        }
//    }
//
//    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        private val textView: TextView = view.findViewById(R.id.textView)
//        fun bind(viewItem: ViewItem.Item) {
//            textView.text = viewItem.item.name
//        }
//    }
//}
