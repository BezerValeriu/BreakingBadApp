package com.example.movie

import android.app.Application
import dagger.internal.DoubleCheck.lazy
import com.example.movie.db.db
import com.example.movie.repository.CharacterRepository

class BreakingBadApplication : Application() {

     //val database = db.getDatabase(this)
     //val database by lazy { db.getDatabase(this) }
     val characterRepository = CharacterRepository()

   /* lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }*/
}