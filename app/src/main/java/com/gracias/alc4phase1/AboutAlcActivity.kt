package com.gracias.alc4phase1

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_about_alc.*
import android.net.NetworkInfo
import android.content.Context.CONNECTIVITY_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.net.ConnectivityManager
import android.webkit.WebViewClient
import android.widget.Toast


class AboutAlcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_alc)

        val actionBar = supportActionBar
        val title = getString(R.string.about_alc);
        actionBar!!.title =title

        actionBar.setDisplayHomeAsUpEnabled(true)

        if (!isNetworkAvailable()) {
            Toast.makeText(this, "Please check your internet connection", Toast.LENGTH_SHORT).show()

        } else {
            webview.webViewClient = WebViewClient()
            webview.loadUrl("https://andela.com/alc/")


        }

    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
