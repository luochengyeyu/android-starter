package com.zy.starter.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.dylanc.loadingstateview.LoadingState
import com.dylanc.loadingstateview.LoadingStateDelegate
import com.dylanc.viewbinding.base.ActivityBinding
import com.dylanc.viewbinding.base.ActivityBindingDelegate
import com.zackratos.ultimatebarx.ultimatebarx.statusBarOnly
import com.zy.starter.R

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity(),
    LoadingState by LoadingStateDelegate(), ActivityBinding<VB> by ActivityBindingDelegate() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithBinding()
        binding.root.decorate(this)
        statusBarOnly {
            fitWindow = true
            colorRes = R.color.white
            light = true
        }
    }

}