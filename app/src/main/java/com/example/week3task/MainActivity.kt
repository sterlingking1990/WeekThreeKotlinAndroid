package com.example.week3task

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count:Int=0;
    var countRemoved:Int=0;
    var backClicked:Boolean=false;
    private val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        handler.postDelayed({
            kotlin.run {
                tvLifeCycleStat.text="onCreate"
            }
        },1500)


        btnAddNewFragment.setOnClickListener {
            if(backClicked){
                count -= countRemoved
                if(count<0){
                    count=0
                }
                backClicked=false
                countRemoved=0

            }
            count+=1
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.dynamicFragmentFrame,FragmentOne.newInstance(count))
                addToBackStack(null)
                commit()
            }
        }

        btnRemoveFragment.setOnClickListener {
            backClicked=true
            supportFragmentManager.beginTransaction().apply {
                supportFragmentManager.popBackStack()
                countRemoved+=1
                if(countRemoved>count){
                    Toast.makeText(this@MainActivity,"No more fragment to remove, Click Add to Add More Fragment",Toast.LENGTH_LONG).show()
                }
                commit()
            }
        }

        //launch second activity
        btnLaunchActivityTwo.setOnClickListener {
          startActivity(Intent(this,SecondActivity::class.java))
        }
    }



    override fun onStart() {
        super.onStart()

        handler.postDelayed({
            kotlin.run {
                tvLifeCycleStat.text="onStart"
            }
        },2000);

    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed({
            kotlin.run{
                tvLifeCycleStat.text="onResume"
            }
        },2500);
        tvLifeCycleStat.text="onResume"
    }

    override fun onPause() {
        super.onPause()
        tvLifeCycleStat.text="onPause"
    }

    override fun onStop() {
        super.onStop()

        handler.postDelayed({
            kotlin.run {
                tvLifeCycleStat.text="onStop"
            }
        },1000);
    }

    override fun onRestart() {
        super.onRestart()

        handler.postDelayed({
            kotlin.run{
                tvLifeCycleStat.text="onRestart"
            }
        },1000);
    }


    override fun onDestroy() {
        super.onDestroy()
        handler.postDelayed({
            kotlin.run{

                tvLifeCycleStat.text="onDestroy"
            }
        },1000);
    }

}