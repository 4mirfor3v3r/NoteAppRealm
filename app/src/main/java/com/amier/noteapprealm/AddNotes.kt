package com.amier.noteapprealm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_add_notes.*
import java.lang.Exception

class AddNotes : AppCompatActivity() {
    lateinit var realm:Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)
        realm = Realm.getDefaultInstance()
        edit_save.setOnClickListener{
            saveToDB()
        }
    }

    private fun saveToDB() {
        try {
            realm.beginTransaction()

            val currentIdNumber:Number? = realm.where(Notes::class.java).max("id")
            val nextId:Int

            nextId = if(currentIdNumber == null){
                1
            }else{
                currentIdNumber.toInt() + 1
            }

            val notes = Notes()
            notes.id = nextId
            notes.title = edit_title.text.toString()
            notes.description = edit_description.text.toString()

            realm.copyToRealmOrUpdate(notes)
            realm.commitTransaction()

            Toast.makeText(this,"Notes Added Successfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }catch (e:Exception){
            e.printStackTrace()
            Toast.makeText(this,"Failed : ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}
