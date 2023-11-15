package com.applabs.animationapp


import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.applabs.animationapp.ticker.TickerUtils
import com.applabs.animationapp.ticker.TickerView
import java.text.NumberFormat
import java.util.Locale


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tickerView = findViewById<TickerView>(R.id.tickerView);
        tickerView.setCharacterLists(TickerUtils.provideNumberList())
        /*  tickerView.setText("0,00,000", true)
          tickerView.setText("5,89,042", true)*/


        val seekBar = findViewById<SeekBar>(R.id.seekbar)

        val numberFormat = NumberFormat.getNumberInstance(Locale("en", "IN"))

        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

                tickerView.setText("₹" + numberFormat.format(progress.toLong()))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

    }


}