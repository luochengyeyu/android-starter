package com.zy.starter.features.image.ui

import android.os.Bundle
import com.dylanc.longan.startActivity
import com.zy.starter.base.BaseActivity
import com.zy.starter.databinding.ActivityImageBinding

class ImageActivity : BaseActivity<ActivityImageBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        setToolbar("ImageActivity")
        binding.run {
            btnCoil.setOnClickListener {
                startActivity<CoilActivity>()
            }
            btnImgSelector.setOnClickListener {
                startActivity<ImageSelectorActivity>()
            }
        }
    }

}