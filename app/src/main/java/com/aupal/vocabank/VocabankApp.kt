package com.aupal.vocabank

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aupal.vocabank.data.VocabData
import com.aupal.vocabank.ui.MainScreen
import com.aupal.vocabank.ui.detail.DetailScreen
import com.aupal.vocabank.ui.tabItem.Screen

@Composable
fun VocabankApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        modifier = modifier

    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Main.route,
            modifier = modifier.padding(innerPadding)
        ){
            composable(Screen.Main.route){
                MainScreen(
                    navigateToDetail = { vocab, data ->
                        navController.currentBackStackEntry?.savedStateHandle?.set("vocab", data)
                        navController.navigate(Screen.Detail.createRoute(vocab))
                    }
                )
            }
            composable(Screen.Detail.route){
                val vocab = navController.previousBackStackEntry?.savedStateHandle?.get<VocabData>("vocab")
                if (vocab != null){
                    DetailScreen(
                        vocab,
                        navigateBack = {
                            navController.navigateUp()
                        }
                    )
                }else {
                    Log.d("DetailScreen", "vocab is null")
                }
            }
        }
    }
    }
