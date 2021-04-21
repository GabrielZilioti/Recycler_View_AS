package com.example.r_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val lista: ArrayList<R_Item> = ArrayList()
    private val adapter = R_Adapter(lista)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view = findViewById<RecyclerView>(R.id.recycler_view)

        view.adapter = adapter
        view.layoutManager = LinearLayoutManager(this)
        view.setHasFixedSize(true)
        findViewById<Button>(R.id.botao).setOnClickListener {
            inserir()
        }

    }

    fun inserir(){
        val texto : TextView = findViewById(R.id.texto)

        if(texto.text.isEmpty()) {
            Toast.makeText(this, "Adicione um título para o item.", Toast.LENGTH_SHORT).show()

            }else{
                val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")

                dateFormat.timeZone = TimeZone.getTimeZone("GMT-3")

                val newItem = R_Item(
                    R.mipmap.yokai_round,
                    texto.text.toString(),
                    dateFormat.format(Date())
                )

                lista.add(lista.size, newItem)
                adapter.notifyItemInserted(lista.size)
                texto.setText("")


            }
        }
    }
