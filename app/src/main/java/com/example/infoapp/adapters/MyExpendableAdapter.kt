package com.example.infoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ListView
import com.example.infoapp.databinding.ItemBinding
import com.example.infoapp.databinding.ItemChildBinding

class MyExpendableAdapter(val titList: ArrayList<String>, val map:HashMap<String, ArrayList<String>>)
    : BaseExpandableListAdapter() {
    override fun getGroupCount(): Int = titList.size
    override fun getChildrenCount(p0: Int): Int {
        val groupName = titList[p0]
        return map[groupName]!!.size
    }
    override fun getGroup(p0: Int): Any {
        return titList[p0]
    }
    override fun getChild(p0: Int, p1: Int): Any {
        val parentName = titList[p0]
        val listChild = map[parentName]!!
        return listChild[p1]
    }
    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }
    override fun getChildId(p0: Int, p1: Int): Long {
        return p0.toLong()
    }
    override fun hasStableIds(): Boolean {
        return false
    }
    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        val itemParentBinding = ItemBinding.inflate(LayoutInflater.from(p3?.context), p3, false)
        itemParentBinding.tvParent.text = titList[p0]
        return itemParentBinding.root
    }
    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        val itemChildBinding = ItemChildBinding.inflate(LayoutInflater.from(p4?.context), p4, false)
        itemChildBinding.tvChild.text = map[titList[p0]]?.get(p1)
        return itemChildBinding.root
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

}