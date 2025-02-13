package com.bluewave.modernapp.data.local.di

import android.content.Context
import androidx.room.Room
import com.bluewave.modernapp.data.local.database.AppDatabase
import com.bluewave.modernapp.data.local.database.OneModelDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, "ModernApp").build()
    }

    @Provides
    fun provideOneModelDao(appDatabase: AppDatabase): OneModelDao {
        return appDatabase.oneModelDao()
    }
}