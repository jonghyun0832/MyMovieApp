package com.example.mymovieapp.library.storage.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.mymovieapp.library.storage.IStorage
import com.example.mymovieapp.library.storage.StorageManager
import com.example.mymovieapp.library.storage.helpers.DataConverter
import com.example.mymovieapp.library.storage.helpers.DataEncoding
import com.example.mymovieapp.library.storage.prefs.SharedPrefsStorageProvider
import com.example.mymovieapp.library.storage.prefs.StorageProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Singleton
    @Provides
    fun bindOnDiscStorage(
        storage: StorageProvider,
        converter: DataConverter,
        encoding: DataEncoding
    ): IStorage = StorageManager(storage, converter, encoding)

    @Provides
    fun provideSharePrefStorageProvider(provider: SharedPrefsStorageProvider): StorageProvider =
        provider

}
