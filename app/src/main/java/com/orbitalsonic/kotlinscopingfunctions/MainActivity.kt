package com.orbitalsonic.kotlinscopingfunctions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    var alpha: String? = null
    var dear = "Dear"
    val tag = "scopingTag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kotlinScopingFunction()
    }

    private fun kotlinScopingFunction(){
        /**
         * let
         * let return last line
         */
        val size = alpha?.let{
            // "it" is the value of alpha at the time of the check and it will remain same in this let scope even if the value of alpha changes after somewhere else
            val alphaSize: Int = it.length
            alphaSize
        } ?: 0 // if alpha is null 0 is assigned to size wi

        Log.d(tag,"$size")

        /**
         * also
         * also does not return last line, it return the object it was called on
         */

        val myString = dear.also {
            Log.d(tag,"$it: ${it.length}")
            dear = "Dear Friend how are you"
        }
        Log.d(tag,myString)


        /**
         * apply
         * Apply initialize the object but don't accept return statement (returns the object)
         */

        val myIntent = Intent().apply {
            putExtra(" ", "")
            putExtra(" ", 0)
            action = ""
        }


        val appsData: AppsData = AppsData().apply {
            appName = "Name"
            appPackage = "com.myapp"
            ischecked = true
        }

        /**
         * run
         * run operator can be used to initialize an object and return the result of it.
         * Run (same as apply, but returns the last line)
         */

        val myIntent2 = Intent().run {
            putExtra(" ", "")
            putExtra(" ", 0)
            action = ""
        }

        /**
         * with
         * With (same as run with different syntax)
         * it doesn´t allow to do a null check
         */

        val myIntent3 = with(Intent()){
            putExtra(" ", "")
            putExtra(" ", 0)
            action = ""
        }

        val App2: AppsData = AppsData()
        with(App2){
            appName = "why we need with"
            appPackage = "i guess we don't"
        }

    }
}