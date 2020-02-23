package com.amier.noteapprealm

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApp:Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("Notes.db")
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(config)
    }
}