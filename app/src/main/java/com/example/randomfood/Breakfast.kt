package com.example.randomfood

import android.app.SearchManager
import android.content.ActivityNotFoundException
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.withStyledAttributes
import kotlin.random.Random

class Breakfast : AppCompatActivity() {
    private val foods = ArrayList<Food>()

    val foodPicArray = arrayOf(R.drawable.eggcake, R.drawable.hamburger, R.drawable.potatocake, R.drawable.sandwich)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breakfast)
        foods.add(Food("蛋餅", 30, foodPicArray[0]))
        foods.add(Food("三明治", 40,foodPicArray[3]))
        foods.add(Food("漢堡", 80,foodPicArray[1]))
        foods.add(Food("薯餅", 30,foodPicArray[2]))

        val chooseBtn = findViewById<Button>(R.id.chooseBtn)
        val result = findViewById<TextView>(R.id.tv_result)
        val onehundred = findViewById<RadioButton>(R.id.onehundred)
        val twohundred = findViewById<RadioButton>(R.id.twohundred)
        val threehundred = findViewById<RadioButton>(R.id.threehundred)
        val fourhundred = findViewById<RadioButton>(R.id.fourhundred)
        val fivehundred = findViewById<RadioButton>(R.id.fivehundred)
        val searchBtn = findViewById<Button>(R.id.searchBtn)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        val breakfastImg = findViewById<ImageView>(R.id.breakfastImg)

        chooseBtn.setOnClickListener{
            if (radioGroup.getCheckedRadioButtonId() == -1)
            {
                Toast.makeText(getApplicationContext(), "請選擇你有多少錢", Toast.LENGTH_SHORT).show()
            }else{
                val myFood = ArrayList<Food>()
                if(onehundred.isChecked){
                    for (item in foods){
                        if(item.price <= 100){
                            myFood.add(item)
                        }
                    }
                }

                if(twohundred.isChecked){
                    for (item in foods){
                        if(item.price <= 200){
                            myFood.add(item)
                        }
                    }
                }

                if(threehundred.isChecked){
                    for (item in foods){
                        if(item.price <= 300){
                            myFood.add(item)
                        }
                    }
                }

                if(fourhundred.isChecked){
                    for (item in foods){
                        if(item.price <= 400){
                            myFood.add(item)
                        }
                    }
                }

                if(fivehundred.isChecked){
                    for (item in foods){
                        myFood.add(item)
                    }
                }
                val mediaplayer = MediaPlayer.create(this,R.raw.winning)
                mediaplayer.start()
                val r = Random.nextInt(myFood.size)
                result.text = myFood.get(r).name
                breakfastImg.setBackgroundResource(myFood.get(r).picture)
            }





        }

        searchBtn.setOnClickListener{
            val searchTerms = result.text.toString()
            if(!searchTerms.equals("")){
                searchNet(searchTerms)
            }
        }






    }

    fun searchNet(words:String){
        try{
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, words)
            startActivity(intent)
        }catch (e : ActivityNotFoundException){
            e.printStackTrace()
            searchNetCompat(words)
        }

    }

    fun searchNetCompat(words : String){
        try {
            val uri = Uri.parse("http://www.google.com/#q="+words)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }catch (e: ActivityNotFoundException){
            e.printStackTrace()
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }
}