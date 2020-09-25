package com.example.fragmenttry2.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.fragmenttry2.FishModel
import com.example.fragmenttry2.R

class FishAdapter(activity: Activity, var listname: ArrayList<FishModel>) : BaseAdapter() {

    private var mActivity = activity
    private var mListView = listname.size

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        val inflater = mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflater.inflate(R.layout.element_fish, null)

        val headlineText = v.findViewById(R.id.fishTextView) as TextView

//        val headlineText = v.findViewById(R.id.fishTextView) as TextView
//        val headlineText = v.findViewById(R.id.fishTextView) as TextView


        for(x in listname) {
            headlineText.text = x.fishName
        }

        return v
    }

    override fun getCount(): Int {

        return mListView
    }
    override fun getItem(position: Int): Any? {

        return listname[position]
    }
    override fun getItemId(position: Int): Long {
        return listname[position].id
    }
}