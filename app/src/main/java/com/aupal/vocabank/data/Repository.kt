package com.aupal.vocabank.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class Repository(private val db : FirebaseFirestore) {
    suspend fun addVocab(vocabData: VocabData){
        val vocabMap = hashMapOf(
            "vocab" to vocabData.vocab,
            "meaning" to vocabData.meaning,
            "sentence" to vocabData.sentence,
        )

        val documentRef = db.collection("vocab")
            .add(vocabMap)
            .await()

        val generateId = documentRef.id

        val vocabWithId = vocabData.copy(id = generateId)

        db.collection("vocab")
            .document(generateId)
            .set(vocabWithId.toMap())
            .await()
    }
}