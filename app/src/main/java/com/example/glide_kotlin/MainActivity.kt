package com.example.glide_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.glide_kotlin.databinding.ActivityMainBinding
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class MainActivity : AppCompatActivity() {
    private val imageUrl1="https://cdn.pixabay.com/photo/2016/12/13/21/20/alien-1905155_960_720.png"
    private val imageUrl2="https://cdn.pixabay.com/photo/2016/11/29/12/30/phone-1869510_960_720.jpg"
    private val imageUrl3="https://cdn.pixabay.com/photo/2017/12/10/17/00/robot-3010309_960_720.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding:ActivityMainBinding= ActivityMainBinding.inflate(layoutInflater)
        val root=binding.root
        super.onCreate(savedInstanceState)
        setContentView(root)

        HttpsTrustManager.allowAllSSL()
        Glide.with(this)
            .load(imageUrl1)
            .into(binding.image1)
        Glide.with(this)
            .load(imageUrl2)
            .override(300,400)
            .centerCrop()
            .error(R.drawable.ic_launcher_background)
            .into(binding.image2)
        Glide.with(this)
            .load(imageUrl3)
            .fitCenter()
            .circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.image3)
    }


}