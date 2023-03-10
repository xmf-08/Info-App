package com.example.infoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import android.widget.Toast
import com.example.infoapp.adapters.MyExpendableAdapter
import com.example.infoapp.databinding.ActivityMainBinding
import com.example.infoapp.utils.MyData

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var myExpendableAdapter: MyExpendableAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MyData.addMap()

        myExpendableAdapter = MyExpendableAdapter(MyData.titleList, MyData.map)
        binding.myExpendableListView.setAdapter(myExpendableAdapter)

        binding.myExpendableListView.setOnChildClickListener { p0, p1, p2, p3, p4 ->
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("keyName", p2)
            intent.putExtra("keyInfo", p3)
            startActivity(intent)
            true
        }
    }
}