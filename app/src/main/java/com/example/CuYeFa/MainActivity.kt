package com.example.CuYeFa

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isInvisible
import com.example.mygame.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var leftImage: ImageView
    lateinit var rightImage: ImageView
    lateinit var goButton: Button
    lateinit var player1 : TextView
    lateinit var player2 : TextView
    lateinit var score1 : TextView
    lateinit var score2 : TextView
    lateinit var win : TextView
    lateinit var exit: Button
    var leftPlayer = 0
    var rightPlayer = 0
    var score = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        exit = findViewById(R.id.b_exit)
        leftImage = findViewById(R.id.iv_left)
        rightImage = findViewById(R.id.iv_right)
        goButton = findViewById(R.id.b_go)
        score1 = findViewById(R.id.tv_score1)
        score2 = findViewById(R.id.tv_score2)
        win = findViewById(R.id.tv_win)
    }
    fun buttonGo(view: View){
        val arrayImage = arrayOf("scissors", "paper", "rock")
        val left = arrayImage.random()
        val right = arrayImage.random()
        val leftID = resources.getIdentifier("@drawable/$left", null, packageName)
        leftImage.setImageResource(leftID)
        val rightID = resources.getIdentifier("@drawable/$right", null, packageName)
        rightImage.setImageResource(rightID)
            if (left == arrayImage[0] && right == arrayImage[1]) {
                leftPlayer += 1
                score1.text = leftPlayer.toString()
            } else if (left == arrayImage[0] && right == arrayImage[2]) {
                rightPlayer += 1
                score2.text = rightPlayer.toString()
            } else if (left == arrayImage[1] && right == arrayImage[0]) {
                rightPlayer += 1
                score2.text = rightPlayer.toString()
            } else if (left == arrayImage[1] && right == arrayImage[2]) {
                leftPlayer += 1
                score1.text = leftPlayer.toString()
            } else if (left == arrayImage[2] && right == arrayImage[0]) {
                leftPlayer += 1
                score1.text = leftPlayer.toString()
            } else if (left == arrayImage[2] && right == arrayImage[1]) {
                rightPlayer += 1
                score2.text = rightPlayer.toString()
            }
        if (leftPlayer == score) {
            win.text = "Player 1 WON!"
            b_go.visibility = View.INVISIBLE
            again.visibility = View.VISIBLE
        }else if (rightPlayer == score){
            win.text = "Player 2 WON!"
            b_go.visibility = View.INVISIBLE
            again.visibility = View.VISIBLE
        }
    }
    fun restart (view: View){
        leftPlayer = 0
        rightPlayer = 0
        score1.text = "0"
        score2.text = "0"
        win.text = ""
        b_go.visibility = View.VISIBLE
        again.visibility = View.INVISIBLE
        leftImage.setImageResource(R.drawable.back)
        rightImage.setImageResource(R.drawable.back)
    }
    fun exitB (view: View){
        exitProcess(-1)
    }






}
