package com.example.fragmenttry2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import android.widget.ListView

import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {
    private lateinit var mListView: ListView
    private lateinit var mActivity: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        mActivity = activity as MainActivity
        var fishList = ArrayList<FishModel>()
        fishList.addAll(
            fillArray(
                resources.getStringArray(R.array.fishes)
            )

        )
        mListView = listView
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, fishList)
        mListView.adapter =  adapter
        return view
    }


    private fun fillArray(namesArray: Array<String>): List<FishModel> {
        val listItemArray = ArrayList<FishModel>()
        for (values in namesArray.indices) {
            val listItem = FishModel(namesArray[values])
            listItemArray.add(listItem)
        }
        return listItemArray
    }
}