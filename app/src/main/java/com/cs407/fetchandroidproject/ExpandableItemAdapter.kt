package com.cs407.fetchandroidproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class ExpandableItemAdapter(
    private val context: Context,
    private val headers: List<Int>,
    private val children: Map<Int, List<Item>>
) : BaseExpandableListAdapter() {

    override fun getGroupCount() = headers.size

    override fun getChildrenCount(groupPosition: Int) = children[headers[groupPosition]]?.size ?: 0

    override fun getGroup(groupPosition: Int) = headers[groupPosition]

    override fun getChild(groupPosition: Int, childPosition: Int) = children[headers[groupPosition]]?.get(childPosition)

    override fun getGroupId(groupPosition: Int) = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int) = childPosition.toLong()

    override fun hasStableIds() = false

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        val headerTitle = getGroup(groupPosition).toString()
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.header_view, parent, false)
        val listHeaderTextView = view.findViewById<TextView>(R.id.headerTextView)
        listHeaderTextView.text = "List ID: $headerTitle"
        return view
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        val child = getChild(groupPosition, childPosition) ?: return convertView!!
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        val listItemTextView = view.findViewById<TextView>(R.id.textView)
        listItemTextView.text = child.name
        return view
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int) = true
}
