package com.aupal.vocabank.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aupal.vocabank.ui.about.AboutScreen
import com.aupal.vocabank.ui.add.AddScreen
import com.aupal.vocabank.ui.list.ListScreen
import com.aupal.vocabank.ui.tabItem.ScreenData
import com.aupal.vocabank.ui.theme.InterFamily
import com.aupal.vocabank.ui.theme.VocabankTheme
import kotlinx.coroutines.launch

@Composable
fun VocabankApp(
    modifier: Modifier = Modifier,
){
    val tabs = listOf(
        ScreenData("Add") { AddScreen() },
        ScreenData("Vocabulary") { ListScreen() },
        ScreenData("About") { AboutScreen() },
    )


    var selectedTabIndex by remember { mutableStateOf(1) }
    val pagerState = rememberPagerState(initialPage = selectedTabIndex){
        tabs.size
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(pagerState.currentPage) {
        selectedTabIndex = pagerState.currentPage
    }


    Column {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = modifier.height(60.dp),
        ){
            tabs.forEachIndexed{ index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                        selectedTabIndex = index
                    },
                    text = {
                        if(index ==  selectedTabIndex){
                        Text(
                            item.title,
                            fontFamily = InterFamily,
                            fontWeight = FontWeight.Bold,
                            )
                        } else {
                            Text(
                            item.title,
                            fontFamily = InterFamily,
                            fontWeight = FontWeight.Normal
                            )
                        }
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
        ){ page ->
            tabs[page].content()
        }
    }


}

@Preview(showBackground = true)
@Composable
fun VocabankAppPreview(){
    VocabankTheme(
        dynamicColor = false
    ) {

        VocabankApp()
    }
}