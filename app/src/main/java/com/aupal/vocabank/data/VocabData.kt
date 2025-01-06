package com.aupal.vocabank.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VocabData(
    val id: Int = 0,
    val vocab: String,
    val meaning: String,
    val sentence: String,
    var documentId: String? = null
) : Parcelable {

    fun toMap(): Map<String, Any> {
        return mapOf(
            "vocab" to vocab,
            "meaning" to meaning,
            "sentence" to sentence
        )
    }
}