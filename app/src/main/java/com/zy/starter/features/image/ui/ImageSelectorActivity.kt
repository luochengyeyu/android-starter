package com.zy.starter.features.image.ui

import android.os.Bundle
import com.zy.starter.base.BaseActivity
import com.zy.starter.databinding.ActivityImageSelectorBinding

class ImageSelectorActivity : BaseActivity<ActivityImageSelectorBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        setToolbar("图片选择库")
        binding.run {
            btnPickSingle.setOnClickListener {
            }
            btnPickMulti.setOnClickListener {
                //startActivity<ImgSelectorActivity>()
            }
        }
    }

}