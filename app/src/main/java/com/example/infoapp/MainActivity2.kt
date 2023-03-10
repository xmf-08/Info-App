package com.example.infoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.infoapp.databinding.ActivityMain2Binding
import com.example.infoapp.utils.MyData

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val a = intent.getStringExtra("key")
        binding.txtMalumot.text = a
        val indexName = intent.getIntExtra("keyName",0)
        val indexInfo = intent.getIntExtra("keyInfo",0)
        supportActionBar?.title = MyData.getArray(indexName)[indexInfo].name
        binding.txtMalumot.text = MyData.getArray(indexInfo)[indexInfo].malumot
    }
}