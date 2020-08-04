package com.example.week3task

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    var horizontalCount=0
    var verticalCount=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        if (savedInstanceState!=null){
            horizontalCount=savedInstanceState.getInt("horizontalCount")
            verticalCount=savedInstanceState.getInt("verticalCount")
        }

        var orientation=resources.configuration.orientation
        if (orientation==Configuration.ORIENTATION_LANDSCAPE){
            horizontalCount+=1
            tvOrientation.text="Horizontal Count $horizontalCount"
        }
        if(orientation==Configuration.ORIENTATION_PORTRAIT){
            verticalCount+=1
            tvOrientation.text="Vertical Count $verticalCount"
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("horizontalCount",horizontalCount)
        outState.putInt("verticalCount",verticalCount)

    }
}