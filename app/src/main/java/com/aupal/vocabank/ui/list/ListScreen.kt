package com.aupal.vocabank.ui.list

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aupal.vocabank.ViewModelFactory
import com.aupal.vocabank.data.VocabData
import com.aupal.vocabank.di.Injection
import com.aupal.vocabank.ui.component.LoadingAnimation
import com.aupal.vocabank.ui.component.VocabItem
import com.aupal.vocabank.ui.state.UiState

@Composable
fun ListScreen(
    viewModel: ListViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(LocalContext.current)
        )
    ),
    modifier: Modifier = Modifier,
    navigateToDetail: (VocabData) -> Unit
){
    val vocabState by viewModel.vocabState


    LaunchedEffect(Unit) {
        viewModel.getVocab()
    }
    Log.d("ListScreen", "vocabState: $vocabState")

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        when(vocabState){
            is UiState.Loading -> {
                LoadingAnimation()
            }
            is UiState.Success -> {
                val data = (vocabState as UiState.Success<List<VocabData>>).data

                Log.d("ListScreen", "data: $data")
                ListContent(data, navigateToDetail)

            }

            is UiState.Error -> {}

            else -> {}
        }
    }


}

@Composable
fun ListContent(
    data: List<VocabData>,
    navigateToDetail: (VocabData) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(data) { data ->
            VocabItem(
                data,
                modifier = modifier.clickable {
                    navigateToDetail(data)
                }
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview(){

}