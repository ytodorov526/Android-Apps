package com.TicTacToe20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun buClick(view: View){
        val buSelected = view as Button
        var cellID=0
        when(buSelected.id){
            R.id.bu1 ->cellID=1
            R.id.bu2 ->cellID=2
            R.id.bu3 ->cellID=3
            R.id.bu4 ->cellID=4
            R.id.bu5 ->cellID=5
            R.id.bu6 ->cellID=6
            R.id.bu7 ->cellID=7
            R.id.bu8 ->cellID=8
            R.id.bu9 ->cellID=9
        }

        Toast.makeText(this,"ID:"+cellID,Toast.LENGTH_LONG).show()

        PlayGame(cellID,buSelected)

        CheckWinner()
    }

    protected fun resetGame(view:View){
        Player1.clear()
        Player2.clear()
        bu1.setBackgroundResource(R.color.col2)
        bu2.setBackgroundResource(R.color.col2)
        bu3.setBackgroundResource(R.color.col2)
        bu4.setBackgroundResource(R.color.col2)
        bu5.setBackgroundResource(R.color.col2)
        bu6.setBackgroundResource(R.color.col2)
        bu7.setBackgroundResource(R.color.col2)
        bu8.setBackgroundResource(R.color.col2)
        bu9.setBackgroundResource(R.color.col2)

        bu1.text=""
        bu2.text=""
        bu3.text=""
        bu4.text=""
        bu5.text=""
        bu6.text=""
        bu7.text=""
        bu8.text=""
        bu9.text=""

        bu1.isEnabled=true
        bu2.isEnabled=true
        bu3.isEnabled=true
        bu4.isEnabled=true
        bu5.isEnabled=true
        bu6.isEnabled=true
        bu7.isEnabled=true
        bu8.isEnabled=true
        bu9.isEnabled=true

        winner=-1
        onewinner=false

    }
    var Player1=ArrayList<Int>()
    var Player2=ArrayList<Int>()


    var ActivePlayer=1

    fun PlayGame(cellID:Int, buSelected:Button){



        if(ActivePlayer==1){
            buSelected.text="X"
            buSelected.setBackgroundResource(R.color.material_blue_grey_950)
            Player1.add(cellID)
            ActivePlayer=2
            AutoPlay()
        }else
        {
            buSelected.text="0"
            buSelected.setBackgroundResource(R.color.material_deep_teal_500)
            Player2.add(cellID)
            ActivePlayer=1

        }

        buSelected.isEnabled=false

    }

    var winner=-1
    var onewinner=false
    fun CheckWinner(){


        //row1
        if(Player1.contains(1)&& Player1.contains(2)&&Player1.contains(3)){
            winner=1
        }
        if(Player2.contains(1)&& Player2.contains(2)&&Player2.contains(3)){
            winner=2
        }

        //row 2
        if(Player1.contains(4)&& Player1.contains(5)&&Player1.contains(6)){
            winner=1
        }
        if(Player2.contains(4)&& Player2.contains(5)&&Player2.contains(6)){
            winner=2
        }

        //row 3
        if(Player1.contains(7)&& Player1.contains(8)&&Player1.contains(9)){
            winner=1
        }
        if(Player2.contains(7)&& Player2.contains(8)&&Player2.contains(9)){
            winner=2
        }

        //col 1
        if(Player1.contains(1)&& Player1.contains(4)&&Player1.contains(7)){
            winner=1
        }
        if(Player2.contains(1)&& Player2.contains(4)&&Player2.contains(7)){
            winner=2
        }

        //col 2
        if(Player1.contains(2)&& Player1.contains(5)&&Player1.contains(8)){
            winner=1
        }
        if(Player2.contains(2)&& Player2.contains(5)&&Player2.contains(8)){
            winner=2
        }

        //col 3
        if(Player1.contains(3)&& Player1.contains(6)&&Player1.contains(9)){
            winner=1
        }
        if(Player2.contains(3)&& Player2.contains(6)&&Player2.contains(9)){
            winner=2
        }

        //diagonal
        if(Player1.contains(1)&& Player1.contains(5)&&Player1.contains(9)){
            winner=1
        }
        if(Player2.contains(1)&& Player2.contains(5)&&Player2.contains(9)){
            winner=2
        }
        //diagonal two
        if(Player1.contains(3)&& Player1.contains(5)&&Player1.contains(7)){
            winner=1
        }
        if(Player2.contains(3)&& Player2.contains(5)&&Player2.contains(7)){
            winner=2
        }

        if(winner !=-1) {
            if (!onewinner) Toast.makeText(this, "The winer is Player " + winner, Toast.LENGTH_LONG).show()
            onewinner = true
        }

    }

    fun AutoPlay() {
        var emptyCells = ArrayList<Int>()
        for (cellID in 1..9) {

            if (!(Player1.contains(cellID) || Player2.contains(cellID))) {

                emptyCells.add(cellID)

            }
        }

        var r = Random()
        val randIndex = r.nextInt(emptyCells.size - 0) + 0

        val cellID = emptyCells[randIndex]

        var buSelect: Button?
        when (cellID) {
            1 -> buSelect = bu1
            2 -> buSelect = bu2
            3 -> buSelect = bu3
            4 -> buSelect = bu4
            5 -> buSelect = bu5
            6 -> buSelect = bu6
            7 -> buSelect = bu7
            8 -> buSelect = bu8
            9 -> buSelect = bu9
            else -> {
                buSelect = bu1}

            }

            PlayGame(cellID, buSelect)
        }


    }