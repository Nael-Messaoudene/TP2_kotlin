package com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.room

import android.app.Application
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.InMemory_NeighborS
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.room.daos.NeighborDao
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.room.entities.NeighborEntity
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.utilis.toEntity
import java.util.concurrent.Executors

@Database(
    entities = [NeighborEntity::class],
    version = 1
)
abstract class NeighborDataBase : RoomDatabase() {
    abstract fun neighborDao(): NeighborDao

    companion object {
        private var instance: NeighborDataBase? = null

        fun getDataBase(application: Application): NeighborDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    application.applicationContext,
                    NeighborDataBase::class.java,
                    "neighbor_database.db"
                ).addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Log.v("ekip","zebi affiche toi")
                        insertFakeData()
                    }
                })
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }

        private fun insertFakeData() {
            Executors.newSingleThreadExecutor().execute {
                InMemory_NeighborS.forEach {
                    instance?.neighborDao()?.add(it.toEntity())
                }
            }
        }
    }
}