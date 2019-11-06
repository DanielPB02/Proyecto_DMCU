package com.example.proyecto_dmcu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

import java.util.ArrayList
import java.util.Locale

class ListViewAdapter(
    // Declare Variables

    internal var mContext: Context?
    ) : BaseAdapter() {
    internal var inflater: LayoutInflater
    private val arraylist: ArrayList<Plants>

    init {
        inflater = LayoutInflater.from(mContext)
        this.arraylist = ArrayList()
        this.arraylist.addAll(SearchFragment.PlantsArrayList)
    }

    inner class ViewHolder {
        internal var name: TextView? = null
    }

    override fun getCount(): Int {
        return SearchFragment.PlantsArrayList.size
    }

    override fun getItem(position: Int): Plants {
        return SearchFragment.PlantsArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var view = view
        val holder: ViewHolder
        if (view == null) {
            holder = ViewHolder()
            view = inflater.inflate(R.layout.listview_item, null)
            // Locate the TextViews in listview_item.xml
            holder.name = view!!.findViewById(R.id.nombrePlanta) as TextView
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }
        // Set the results into TextViews
        holder.name!!.setText(SearchFragment.PlantsArrayList[position].getPlantName())
        return view
    }

    // Filter Class
    fun filter(charText: String) {
        var charText = charText
        charText = charText.toLowerCase(Locale.getDefault())
        SearchFragment.PlantsArrayList.clear()
        if (charText.length == 0) {
            SearchFragment.PlantsArrayList.addAll(arraylist)
        } else {
            for (wp in arraylist) {
                if (wp.getPlantName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    SearchFragment.PlantsArrayList.add(wp)
                }
            }
        }
        notifyDataSetChanged()
    }

}