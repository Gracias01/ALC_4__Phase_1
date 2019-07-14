package com.gracias.alc4phase1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class MyProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        val actionBar = supportActionBar
        val title = getString(R.string.my_profile);
        actionBar!!.title =title

        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
