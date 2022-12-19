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
import kotlin.random.Random

class Lunch : AppCompatActivity() {
    private val twFoods = ArrayList<Food>()
    private val jpFoods = ArrayList<Food>()
    private val amFoods = ArrayList<Food>()
    private val krFoods = ArrayList<Food>()
    val twFoodPicArray = arrayOf(R.drawable.mifen, R.drawable.pigbloodsoup, R.drawable.stinkytofu, R.drawable.beefnoodle,
        R.drawable.goatsoup, R.drawable.nightsteak, R.drawable.drynoodle, R.drawable.dumpling, R.drawable.hotpot,R.drawable.eggfriedrice)
    val jpFoodPicArray = arrayOf(R.drawable.jpsetmeal, R.drawable.sashimi, R.drawable.ramen, R.drawable.sukiyaki, R.drawable.trianglerice, R.drawable.rice)
    val amFoodPicArray = arrayOf(R.drawable.hamburgerpotato, R.drawable.italynoodle, R.drawable.pizza, R.drawable.oneplusone, R.drawable.michilin, R.drawable.halfchicken, R.drawable.fullchicken)
    val krFoodPicArray = arrayOf(R.drawable.koreanchicken, R.drawable.krhotpot, R.drawable.yearcake, R.drawable.krmeat)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunch)

        twFoods.add(Food("米粉",80, twFoodPicArray[0]))
        twFoods.add(Food("豬血湯",60, twFoodPicArray[1]))
        twFoods.add(Food("臭豆腐",60, twFoodPicArray[2]))
        twFoods.add(Food("牛肉麵",150, twFoodPicArray[3]))
        twFoods.add(Food("羊肉爐",550, twFoodPicArray[4]))
        twFoods.add(Food("夜市牛排",220, twFoodPicArray[5]))
        twFoods.add(Food("乾麵",80, twFoodPicArray[6]))
        twFoods.add(Food("水餃",80, twFoodPicArray[7]))
        twFoods.add(Food("火鍋",180, twFoodPicArray[8]))
        twFoods.add(Food("炒飯", 80, twFoodPicArray[9]))


        jpFoods.add(Food("商業定食", 220, jpFoodPicArray[0]))
        jpFoods.add(Food("生魚片料理", 250, jpFoodPicArray[1]))
        jpFoods.add(Food("拉麵", 180, jpFoodPicArray[2]))
        jpFoods.add(Food("壽喜燒", 450, jpFoodPicArray[3]))
        jpFoods.add(Food("7-11飯糰", 80, jpFoodPicArray[4]))
        jpFoods.add(Food("井飯", 180, jpFoodPicArray[5]))



        amFoods.add(Food("漢堡薯條", 180, amFoodPicArray[0]))
        amFoods.add(Food("義大利麵", 120, amFoodPicArray[1]))
        amFoods.add(Food("披薩", 220, amFoodPicArray[2]))
        amFoods.add(Food("麥當勞1+1", 50, amFoodPicArray[3]))
        amFoods.add(Food("米其林餐廳料理", 500, amFoodPicArray[4]))
        amFoods.add(Food("烤半雞", 220, amFoodPicArray[5]))
        amFoods.add(Food("烤全雞", 500, amFoodPicArray[6]))

        krFoods.add(Food("韓式炸雞", 180, krFoodPicArray[0]))
        krFoods.add(Food("部隊鍋", 220, krFoodPicArray[1]))
        krFoods.add(Food("辣炒年糕", 85, krFoodPicArray[2]))
        krFoods.add(Food("韓式烤肉", 450, krFoodPicArray[3]))



        val twBtn = findViewById<Button>(R.id.twBtn)
        val jpBtn = findViewById<Button>(R.id.jpBtn)
        val amBtn = findViewById<Button>(R.id.amBtn)
        val krBtn = findViewById<Button>(R.id.krBtn)
        val result = findViewById<TextView>(R.id.tv_result)
        val onehundred = findViewById<RadioButton>(R.id.onehundred)
        val twohundred = findViewById<RadioButton>(R.id.twohundred)
        val threehundred = findViewById<RadioButton>(R.id.threehundred)
        val fourhundred = findViewById<RadioButton>(R.id.fourhundred)
        val fivehundred = findViewById<RadioButton>(R.id.fivehundred)
        val searchBtn = findViewById<Button>(R.id.searchBtn)
        val lunchImg = findViewById<ImageView>(R.id.lunchImg)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        twBtn.setOnClickListener{
            if (radioGroup.getCheckedRadioButtonId() == -1)
            {
                Toast.makeText(getApplicationContext(), "請選擇你有多少錢", Toast.LENGTH_SHORT).show()
            }else{
                val myFood = ArrayList<Food>()
                if(onehundred.isChecked){
                    for (item in twFoods){
                        if(item.price <= 100){
                            myFood.add(item)
                        }
                    }
                }

                if(twohundred.isChecked){
                    for (item in twFoods){
                        if(item.price <= 200){
                            myFood.add(item)
                        }
                    }
                }

                if(threehundred.isChecked){
                    for (item in twFoods){
                        if(item.price <= 300){
                            myFood.add(item)
                        }
                    }
                }

                if(fourhundred.isChecked){
                    for (item in twFoods){
                        if(item.price <= 400){
                            myFood.add(item)
                        }
                    }
                }

                if(fivehundred.isChecked){
                    for (item in twFoods){
                        myFood.add(item)
                    }
                }
                val r = Random.nextInt(myFood.size)
                val mediaplayer = MediaPlayer.create(this,R.raw.winning)
                mediaplayer.start()
                result.text = myFood.get(r).name
                lunchImg.setBackgroundResource(myFood.get(r).picture)
            }


        }


        jpBtn.setOnClickListener{
            if (radioGroup.getCheckedRadioButtonId() == -1)
            {
                Toast.makeText(getApplicationContext(), "請選擇你有多少錢", Toast.LENGTH_SHORT).show()
            }else{
                val myFood = ArrayList<Food>()
                if(onehundred.isChecked){
                    for (item in jpFoods){
                        if(item.price <= 100){
                            myFood.add(item)
                        }
                    }
                }

                if(twohundred.isChecked){
                    for (item in jpFoods){
                        if(item.price <= 200){
                            myFood.add(item)
                        }
                    }
                }

                if(threehundred.isChecked){
                    for (item in jpFoods){
                        if(item.price <= 300){
                            myFood.add(item)
                        }
                    }
                }

                if(fourhundred.isChecked){
                    for (item in jpFoods){
                        if(item.price <= 400){
                            myFood.add(item)
                        }
                    }
                }

                if(fivehundred.isChecked){
                    for (item in jpFoods){
                        myFood.add(item)
                    }
                }
                val r = Random.nextInt(myFood.size)
                val mediaplayer = MediaPlayer.create(this,R.raw.winning)
                mediaplayer.start()
                result.text = myFood.get(r).name
                lunchImg.setBackgroundResource(myFood.get(r).picture)
            }

        }

        amBtn.setOnClickListener {
            if (radioGroup.getCheckedRadioButtonId() == -1)
            {
                Toast.makeText(getApplicationContext(), "請選擇你有多少錢", Toast.LENGTH_SHORT).show()
            }else{
                val myFood = ArrayList<Food>()
                if(onehundred.isChecked){
                    for (item in amFoods){
                        if(item.price <= 100){
                            myFood.add(item)
                        }
                    }
                }

                if(twohundred.isChecked){
                    for (item in amFoods){
                        if(item.price <= 200){
                            myFood.add(item)
                        }
                    }
                }

                if(threehundred.isChecked){
                    for (item in amFoods){
                        if(item.price <= 300){
                            myFood.add(item)
                        }
                    }
                }

                if(fourhundred.isChecked){
                    for (item in amFoods){
                        if(item.price <= 400){
                            myFood.add(item)
                        }
                    }
                }

                if(fivehundred.isChecked){
                    for (item in amFoods){
                        myFood.add(item)
                    }
                }
                val r = Random.nextInt(myFood.size)
                val mediaplayer = MediaPlayer.create(this,R.raw.winning)
                mediaplayer.start()
                result.text = myFood.get(r).name
                lunchImg.setBackgroundResource(myFood.get(r).picture)
            }

        }

        krBtn.setOnClickListener{
            if (radioGroup.getCheckedRadioButtonId() == -1)
            {
                Toast.makeText(getApplicationContext(), "請選擇你有多少錢", Toast.LENGTH_SHORT).show()
            }else{
                val myFood = ArrayList<Food>()
                if(onehundred.isChecked){
                    for (item in krFoods){
                        if(item.price <= 100){
                            myFood.add(item)
                        }
                    }
                }

                if(twohundred.isChecked){
                    for (item in krFoods){
                        if(item.price <= 200){
                            myFood.add(item)
                        }
                    }
                }

                if(threehundred.isChecked){
                    for (item in krFoods){
                        if(item.price <= 300){
                            myFood.add(item)
                        }
                    }
                }

                if(fourhundred.isChecked){
                    for (item in krFoods){
                        if(item.price <= 400){
                            myFood.add(item)
                        }
                    }
                }

                if(fivehundred.isChecked){
                    for (item in krFoods){
                        myFood.add(item)
                    }
                }
                val r = Random.nextInt(myFood.size)
                val mediaplayer = MediaPlayer.create(this,R.raw.winning)
                mediaplayer.start()
                result.text = myFood.get(r).name
                lunchImg.setBackgroundResource(myFood.get(r).picture)
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
