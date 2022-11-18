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

class Lunch : AppCompatActivity() {
    private val twFoods = ArrayList<Food>()
    private val jpFoods = ArrayList<Food>()
    private val amFoods = ArrayList<Food>()
    private val krFoods = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunch)

        twFoods.add(Food("tw1",80))
        twFoods.add(Food("tw2",120))
        twFoods.add(Food("tw3",400))

        jpFoods.add(Food("jp1", 80))
        jpFoods.add(Food("jp2", 120))
        jpFoods.add(Food("jp3", 400))

        amFoods.add(Food("am1", 80))
        amFoods.add(Food("am2", 120))
        amFoods.add(Food("am3", 400))

        krFoods.add(Food("kr1", 80))
        krFoods.add(Food("kr2", 120))
        krFoods.add(Food("kr3", 400))


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

        twBtn.setOnClickListener{
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
            result.text = myFood.get(r).name

        }


        jpBtn.setOnClickListener{
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
            result.text = myFood.get(r).name
        }

        amBtn.setOnClickListener {
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
            result.text = myFood.get(r).name
        }

        krBtn.setOnClickListener{
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
