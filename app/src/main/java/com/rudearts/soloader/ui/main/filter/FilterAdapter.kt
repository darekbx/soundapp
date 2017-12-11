package com.rudearts.soloader.ui.main.filter

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.rudearts.soloader.R
import com.rudearts.soloader.databinding.FilterItemBinding
import com.rudearts.soloader.databinding.FilterVisibleItemBinding
import com.rudearts.soloader.model.filter.Titlable

class  FilterAdapter<T : Titlable>(context: Context, private var items: List<T>) : ArrayAdapter<T>(context, R.layout.filter_item, items) {

    private val inflater = LayoutInflater.from(context)

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?):View = with(createViewBinding()) {
        titlable = items[position]
        root
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?):View = with(createDropdownBinding()) {
        titlable = items[position]
        root
    }

    private fun createDropdownBinding(): FilterVisibleItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.filter_visible_item, null, false)

    private fun createViewBinding(): FilterItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.filter_item, null, false)

}

