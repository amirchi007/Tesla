package com.amir.neumorphism

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.amir.neumorphism.databinding.ActivityMain2Binding
import soup.neumorphism.ShapeType

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val datalist = listOf(
            Info(
                "Engine",
                "Sleeping Mode",
                false
            ),

            Info(
                "Climate",
                "A/C is ON",
                true
            ),
            Info(
                "Tires",
                "Low pressure",
                true
            ),
            Info(
                "Direction",
                "Automatic mode",
                true
            ),
        )

        val adapter = CardAdapter(datalist)
        binding.recyclerMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerMain.adapter = adapter



        binding.neumorphImageView2.setOnClickListener {
            binding.neumorphImageView2.setShapeType(ShapeType.PRESSED)
            binding.neumorphImageView2.setColorFilter(
                ContextCompat.getColor(this,R.color.blue_light),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
        }
    }

}