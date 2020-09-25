package com.example.fragmenttry2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.fragmenttry2.adapters.FishAdapter
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    private lateinit var mListView: ListView
    private lateinit var mActivity: MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        initViews(view)

        setData()

        return view
    }

    private fun initViews(view: View) {
        mListView = view.findViewById(R.id.listView)
        mActivity = activity as MainActivity
    }

    private fun setData() {
        val idArray: Array<Long> = arrayOf(1, 2, 3, 4)
        val fishList = ArrayList<FishModel>()
        fishList.addAll(
            fillArray(
                resources.getStringArray(R.array.fishes),
                idArray
            )
        )

        val adapter = FishAdapter(mActivity, fishList)
        mListView.adapter =  adapter
    }


    private fun fillArray(namesArray: Array<String>, idArray: Array<Long>): List<FishModel> {
        val listItemArray = ArrayList<FishModel>()
        for (values in namesArray.indices) {
            val listItem = FishModel(namesArray[values], idArray[values])
            listItemArray.add(listItem)
        }
        return listItemArray
    }
}