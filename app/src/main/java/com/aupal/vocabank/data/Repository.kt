package com.aupal.vocabank.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class Repository(private val db : FirebaseFirestore) {
    suspend fun addVocab(vocabData: VocabData){

        db.collection("vocab")
            .add(vocabData.toMap())
            .await()
    }

    suspend fun checkVocab(vocab: String): Boolean{
        val querySnapshot = db.collection("vocab")
            .whereEqualTo("vocab", vocab)
            .get()
            .await()

        return !querySnapshot.isEmpty
    }

    suspend fun getVocab(): List<VocabData> {
        val vocabList = mutableListOf<VocabData>()

        try {
            val snapshot = db.collection("vocab").get().await()
            for (document in snapshot) {
                val vocab = document.toObject(VocabData::class.java)
                vocab.documentId = document.id
                vocabList.add(vocab)
            }
        } catch (e: Exception) {
            println("Error getting documents: $e")
        }

        return vocabList
    }

}