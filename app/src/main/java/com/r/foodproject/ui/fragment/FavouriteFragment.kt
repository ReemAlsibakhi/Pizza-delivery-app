package com.r.foodproject.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.r.foodproject.R
import com.r.foodproject.ui.adapter.DessertAdapter
import com.r.foodproject.ui.model.DatabaseHelper
import kotlinx.android.synthetic.main.favourite.*

class FavouriteFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.favourite, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db= DatabaseHelper(requireContext())

        val favourite_list=db.getFavourite()
        Log.e("hzm", favourite_list.size.toString())
        rv_favourite.layoutManager = LinearLayoutManager(requireContext())
        val adapter = DessertAdapter(requireActivity(), favourite_list)
        rv_favourite.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
