package com.zy.starter.features.image.ui

import android.os.Bundle
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.dylanc.longan.dp
import com.zy.starter.base.BaseActivity
import com.zy.starter.databinding.ActivityCoilBinding

class CoilActivity : BaseActivity<ActivityCoilBinding>() {
    private val url =
        "https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg?auto=compress&cs=tinysrgb&fit=crop&h=627&w=1200"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        setToolbar("Coil使用示例")
        binding.run {
            ivProfilePicture.load(url) {
                transformations(CircleCropTransformation())
            }
            imageView.load(url) {
                transformations(RoundedCornersTransformation(15.dp))
            }
        }
    }

}