package com.aupal.vocabank.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aupal.vocabank.ui.component.VocabItem

@Composable
fun ListScreen(
    list: List<String>,
    modifier: Modifier = Modifier,
){
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(list) { list ->
            VocabItem(list)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview(){
    val data = listOf("Wow", "Rouf", "Aufalin")
    ListScreen(data)
}