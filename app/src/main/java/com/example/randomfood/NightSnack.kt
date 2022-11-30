package com.example.randomfood

import android.app.SearchManager
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class NightSnack : AppCompatActivity() {
    private val foods = ArrayList<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breakfast)
        foods.add(Food("蛋餅", 30, 1))
        foods.add(Food("三明治", 110, 1))
        foods.add(Food("漢堡", 200, 1))
        foods.add(Food("薯餅", 300, 1))

        val chooseBtn = findViewById<Button>(R.id.chooseBtn)
        val result = findViewById<TextView>(R.id.tv_result)
        val onehundred = findViewById<RadioButton>(R.id.onehundred)
        val twohundred = findViewById<RadioButton>(R.id.twohundred)
        val threehundred = findViewById<RadioButton>(R.id.threehundred)
        val fourhundred = findViewById<RadioButton>(R.id.fourhundred)
        val fivehundred = findViewById<RadioButton>(R.id.fivehundred)
        val searchBtn = findViewById<Button>(R.id.searchBtn)

        chooseBtn.setOnClickListener{
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
            val r = Random.nextInt(myFood.size)
            result.text = myFood.get(r).name


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