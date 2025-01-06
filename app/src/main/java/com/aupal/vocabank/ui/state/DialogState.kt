package com.aupal.vocabank.ui.state

sealed class DialogState {
    object Confirmation : DialogState()
    object Existing : DialogState()

}