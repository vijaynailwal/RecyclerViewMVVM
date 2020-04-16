package com.example.recyclerviewmvvm.ui.movies

import android.view.View
import com.example.recyclerviewmvvm.data.models.Movie

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, movie: Movie)
}