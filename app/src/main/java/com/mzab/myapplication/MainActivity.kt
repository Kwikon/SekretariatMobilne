package com.mzab.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        val tabela = findViewById<TableLayout>(R.id.tabela)
        val datatabela = mutableListOf<Array<String>>(arrayOf("wybor1","wybor2","wybor3","wybor4","wybor5"),
                                    arrayOf("dane1a","dane1b","dane1c","dane1d","dane1e"),
                                    arrayOf("dane2a","dane2b","dane2c","dane2d","dane2e"),
                                    arrayOf("dane3a","dane3b","dane3c","dane3d","dane3e"),
                                    arrayOf("dane4a","dane4b","dane4c","dane4d","dane4e"))
        tabela.removeAllViews()
        val firstRow = TableRow(this@MainActivity)
        for (column in datatabela[0]) {
            val tv = TextView(this@MainActivity)
            tv.setPadding(10,10,10,10)
            tv.setBackgroundColor(Color.parseColor("#FF3700B3"))
            tv.textAlignment= View.TEXT_ALIGNMENT_CENTER
            tv.text = column
            firstRow.addView(tv)

        }
        tabela.addView(firstRow)

        var dataSorted = datatabela.subList(1,datatabela.size-1)
        for(element in dataSorted){
            val row = TableRow(this@MainActivity)
            row.weightSum=(tabela.width/dataSorted[0].count()).toFloat()
            for (column in element) {
                val tv = TextView(this@MainActivity)

                tv.setPadding(10,10,10,10)
                tv.setBackgroundColor(Color.parseColor("#FF6200EE"))
                tv.textAlignment= View.TEXT_ALIGNMENT_CENTER
                tv.text = column
                row.addView(tv)
            }
            tabela.addView(row)
        }
    
        
    }
}