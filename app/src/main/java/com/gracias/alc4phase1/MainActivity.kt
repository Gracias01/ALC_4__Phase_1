package com.gracias.alc4phase1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BtnMyProfile.setOnClickListener{
            val intent = Intent(this,MyProfileActivity::class.java)

            startActivity(intent)
        }
        BtnAboutAlc.setOnClickListener{
            val intent = Intent(this,AboutAlcActivity::class.java)

            startActivity(intent)
        }
    }
}
