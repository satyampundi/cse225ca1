package com.example.cse225ca1


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val r1=findViewById<RatingBar>(R.id.ratingBar)
        viewRating(r1)
        progress(r1)
        val r2=findViewById<RatingBar>(R.id.ratingBar2)
        viewRating(r2)
        progress(r2)
        val r3=findViewById<RatingBar>(R.id.ratingBar3)
        viewRating(r3)
        progress(r3)
        val r4=findViewById<RatingBar>(R.id.ratingBar4)
        viewRating(r4)
        progress(r4)
        val r5=findViewById<RatingBar>(R.id.ratingBar5)
        viewRating(r5)
        progress(r5)
        val r6=findViewById<RatingBar>(R.id.ratingBar6)
        viewRating(r6)
        progress(r6)
        val r7=findViewById<RatingBar>(R.id.ratingBar7)
        viewRating(r7)
        progress(r7)
        val r8=findViewById<RatingBar>(R.id.ratingBar8)
        viewRating(r8)
        progress(r8)
        val r9=findViewById<RatingBar>(R.id.ratingBar9)
        viewRating(r9)
        progress(r9)


        val progressBtn = findViewById<Button>(R.id.progressBtn)


        val intentBtn = findViewById<Button>(R.id.intentBtn)
        intentBtn.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://google.com/")
            startActivity(intent)
        }

    }

    private fun progress(rating: RatingBar?) {
        val pgsBar1 = findViewById<ProgressBar>(R.id.progressBar2)

        rating?.setOnRatingBarChangeListener {a,b,c->
            pgsBar1.visibility = View.VISIBLE
            var i = pgsBar1.progress
            Thread{
                while(i<100){
                    i = i+1
                    Handler(Looper.getMainLooper()).post {
                        pgsBar1.progress = i
                        Toast.makeText(this,"progress is " + b.toString(),Toast.LENGTH_SHORT).show()
                        if (i == 100) {
                            pgsBar1.visibility = View.INVISIBLE
                        }
                    }
                    try {
                        Thread.sleep(100)
                    }
                    catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }.start()
        }

    }

    private fun viewRating(rating: RatingBar?) {
        val layout = layoutInflater.inflate(R.layout.custom_toast,null)
        rating?.setOnRatingBarChangeListener{ _, _, _->
    //            Toast.makeText(this,"rating change hua??",Toast.LENGTH_SHORT).show()
            val myToast = Toast(applicationContext)
            myToast.duration = Toast.LENGTH_SHORT
            myToast.setGravity(Gravity.CENTER, 0, 0)
            myToast.view = layout
            myToast.show()
        }

    }
}