package com.amier.noteapprealm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var notelist:ArrayList<Notes>
    lateinit var realm:Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        realm = Realm.getDefaultInstance()
        btn_add.setOnClickListener {
            startActivity(Intent(this, AddNotes::class.java))
            finish()
        }
        notesRV.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)

        getAllNotes()
    }

    private fun getAllNotes() {
        notelist = ArrayList()

        val result = realm.where(Notes::class.java).findAll()
        notesRV.adapter = NotesAdapter(this, result)

        notesRV.adapter!!.notifyDataSetChanged()
    }
}
