package com.zy.starter.features.home.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.dylanc.longan.dp
import com.zy.starter.R
import com.zy.starter.base.BaseActivity
import com.zy.starter.databinding.ActivityImageBinding

class ImageActivity : BaseActivity<ActivityImageBinding>() {
    private val url =
        "https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg?auto=compress&cs=tinysrgb&fit=crop&h=627&w=1200"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        setToolbar("ImageActivity")
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