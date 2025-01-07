package com.aupal.vocabank.ui.tabItem


sealed class Screen(val route: String){
    object Main: Screen("main")
    object Detail: Screen("detail/{vocab}"){
        fun createRoute(vocab: String) = "detail/$vocab"
    }
}