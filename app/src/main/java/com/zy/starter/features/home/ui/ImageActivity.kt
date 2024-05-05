package com.zy.starter.features.home.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.dylanc.longan.dp
import com.dylanc.viewbinding.binding
import com.zy.starter.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    private val binding: ActivityImageBinding by binding()
    private val url =
        "https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg?auto=compress&cs=tinysrgb&fit=crop&h=627&w=1200"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
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