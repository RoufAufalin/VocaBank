package com.aupal.vocabank.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VocabData(
    val id: String = "",
    val vocab: String,
    val meaning: String,
    val sentence: String,
) : Parcelable {
    fun toMap(): Map<String, Any> {
        return mapOf(
            "vocab" to vocab,
            "meaning" to meaning,
            "sentence" to sentence
        )
    }
}