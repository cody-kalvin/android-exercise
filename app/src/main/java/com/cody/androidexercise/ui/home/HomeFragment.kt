package com.cody.androidexercise.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import com.cody.androidexercise.R

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}