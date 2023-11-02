package edu.du.week8activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<ListItem>()
        for (i in 0..22) {
            val itemType = if (i % 2 == 1) ItemAdapter.VIEW_TYPE_ONE else ItemAdapter.VIEW_TYPE_TWO
            val name = if (i % 2 == 1) "" + i else Char('A'.code + i).toString()
            list.add(ListItem(itemType, name))
        }

        val adapter = ItemAdapter(this, list)

        val recycler: RecyclerView = findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter


    }

}