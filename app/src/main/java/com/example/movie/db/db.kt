package com.example.movie.db

import android.content.Context
import androidx.room.*
import com.example.movie.model.BBCharacter
import java.security.AccessControlContext
import java.util.*

@Database(
   entities = [BBCharacter::class],
    version = 1
)

@TypeConverters(AppTypeConverters::class)
abstract class db : RoomDatabase(){

    abstract fun createCharacterDao(): CharacterDao

    companion object{
        @Volatile
        private var INSTANCE: db? = null

        fun getDatabase(context: Context): db {

            return Room.databaseBuilder(context,db::class.java,
                "char")

               .createFromAsset("database/db.db")
                //.addMigrations(MIGRATION_2_3,MIGRATION_3_4)
                .build()

           /* return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    db::class.java,
                    "bbapp.db"
                ).build()
               // INSTANCE = instance
            }
            */
        }
    }
}