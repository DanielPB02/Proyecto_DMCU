package com.example.proyecto_dmcu

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList
import kotlin.math.log

class TutorialAdapter(
    // Declare Variables

    internal var mContext: Context?
) : BaseAdapter() {
    internal var inflater: LayoutInflater
    private val arraylist: ArrayList<Tutoriales>
    val ctx: Context? = mContext

    init {
        inflater = LayoutInflater.from(mContext)
        this.arraylist = ArrayList()
        this.arraylist.addAll(TutorialsFragment.TutoArrayList)
    }

    inner class ViewHolder {
        internal var name: TextView? = null
        internal var img: ImageView? = null
    }

    override fun getCount(): Int {
        return TutorialsFragment.TutoArrayList.size
    }

    override fun getItem(position: Int): Tutoriales {
        return TutorialsFragment.TutoArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun getImageId(position: Int): String {
        var s = TutorialsFragment.TutoArrayList[position].getNombre().toLowerCase()
        s = s.replace("\\s".toRegex(), "")
        return s
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var view = view
        val holder: ViewHolder
        if (view == null) {
            holder = ViewHolder()
            view = inflater.inflate(R.layout.list_view_tutorial, null)
            // Locate the TextViews in listview_item.xml
            holder.name = view!!.findViewById(R.id.nombreTuto) as TextView
            holder.img = view!!.findViewById(R.id.fotoTuto) as ImageView
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }
        // Set the results into TextViews
        val draw = ctx!!.getResources()
            .getIdentifier(getImageId(position), "drawable", ctx!!.getPackageName());
        holder.img!!.setImageResource(draw)
        holder.name!!.setText(TutorialsFragment.TutoArrayList[position].getNombre())
        return view
    }
}