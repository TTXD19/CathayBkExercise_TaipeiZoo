package com.example.cathaybkexercise_taipeizoo

import android.content.Context
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment(), BaseViewInterface {
    override fun getFragmentContext(): Context {
        return requireContext()
    }
}