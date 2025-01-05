package com.aupal.vocabank.di

import android.content.Context
import com.aupal.vocabank.data.Repository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

object Injection {
    fun provideRepository(context: Context): Repository{
        val database = FirebaseFirestore.getInstance()
        return Repository(database)
    }
}