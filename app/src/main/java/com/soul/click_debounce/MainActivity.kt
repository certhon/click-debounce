package com.harry.click_debounce

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.harry.click_debounce.databinding.ActivityMainBinding
import com.harry.click_debounce_runtime.Debounced
import com.harry.click_debounce_runtime.DebouncedPredictor


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DebouncedPredictor.FROZEN_WINDOW_MILLIS = 1000


        binding.fab.setOnClickListener {
            Log.e("harry","哈哈哈")
            Toast.makeText(this,"哈哈哈",LENGTH_SHORT).show()

        }
        binding.fab2.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?) {
                Log.e("harry","嘻嘻嘻")

                Toast.makeText(this@MainActivity,"嘻嘻嘻",LENGTH_SHORT).show()
            }
        })

        binding.fab3.setOnClickListener(object : View.OnClickListener{
            @Debounced
            override fun onClick(v: View?) {
                Log.e("harry","啦啦啦")

                Toast.makeText(this@MainActivity,"啦啦啦",LENGTH_SHORT).show()

            }
        })

        binding.fab4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.fab4) {
            Log.e("harry","啊啊啊")

            Toast.makeText(this@MainActivity,"啊啊啊",LENGTH_SHORT).show()
        }
    }


}