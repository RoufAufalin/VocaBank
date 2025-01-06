package com.aupal.vocabank.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VocabData(
    val id: Int = 0,
    val vocab: String? = null,
    val meaning: String? = null,
    val sentence: String? = null,
    var documentId: String? = null
) : Parcelable {

    fun toMap(): Map<String, String?> {
        return mapOf(
            "vocab" to vocab,
            "meaning" to meaning,
            "sentence" to sentence
        )
    }
}