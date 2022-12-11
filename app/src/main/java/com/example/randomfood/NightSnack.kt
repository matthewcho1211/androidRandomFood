package com.example.randomfood

import android.app.SearchManager
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class NightSnack : AppCompatActivity() {
    private val foods = ArrayList<Food>()
    val nightSnackPicArray = arrayOf(R.drawable.saltedchicken, R.drawable.instantnoodle, R.drawable.mcdonald, R.drawable.yonhedojiang, R.drawable.ranramen,
        R.drawable.ruwei, R.drawable.chickenchops, R.drawable.goatsoup, R.drawable.sweetnothot, R.drawable.stinkytofu, R.drawable.friedsquid)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_night_snack)
        foods.add(Food("鹹酥雞", 30, nightSnackPicArray[0]))
        foods.add(Food("泡麵", 30, nightSnackPicArray[1]))
        foods.add(Food("麥當勞", 30, nightSnackPicArray[2]))
        foods.add(Food("永和豆漿", 30, nightSnackPicArray[3]))
        foods.add(Food("一蘭拉麵", 280, nightSnackPicArray[4]))
        foods.add(Food("滷味", 120, nightSnackPicArray[5]))
        foods.add(Food("雞排", 80, nightSnackPicArray[6]))
        foods.add(Food("羊肉爐", 550, nightSnackPicArray[7]))
        foods.add(Food("甜不辣", 60, nightSnackPicArray[8]))
        foods.add(Food("臭豆腐", 60, nightSnackPicArray[9]))
        foods.add(Food("炸花枝", 60, nightSnackPicArray[10]))



        val chooseBtn = findViewById<Button>(R.id.chooseBtn)
        val result = findViewById<TextView>(R.id.tv_result)
        val onehundred = findViewById<RadioButton>(R.id.onehundred)
        val twohundred = findViewById<RadioButton>(R.id.twohundred)
        val threehundred = findViewById<RadioButton>(R.id.threehundred)
        val fourhundred = findViewById<RadioButton>(R.id.fourhundred)
        val fivehundred = findViewById<RadioButton>(R.id.fivehundred)
        val searchBtn = findViewById<Button>(R.id.searchBtn)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        val nightSnackImg = findViewById<ImageView>(R.id.nightSnackImg)

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
                val r = Random.nextInt(myFood.size)
                result.text = myFood.get(r).name
                nightSnackImg.setBackgroundResource(myFood.get(r).picture)
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