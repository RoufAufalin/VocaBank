package com.aupal.vocabank.ui.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aupal.vocabank.data.VocabData
import com.aupal.vocabank.ui.component.SectionText
import com.aupal.vocabank.ui.list.ListScreen
import com.aupal.vocabank.ui.theme.InterFamily

@Composable
fun DetailScreen(
    vocabData: VocabData,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            colors = CardDefaults.cardColors(Color.White),
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(8.dp)
            ){
                SectionText("EnglishVocab")
                Text(
                    vocabData.vocab.toString(),
                    fontFamily = InterFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                )
                SectionText("Indonesia Meaning")
                Text(
                    vocabData.meaning.toString(),
                    fontFamily = InterFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                )
                SectionText("Example Sentence")
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = null,
                        modifier = modifier.size(10.dp)
                    )
                    Spacer(
                        modifier = modifier.width(4.dp)
                    )
                    Text(
                        vocabData.sentence.toString(),
                        fontFamily = InterFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                }

            }
        }

        Spacer(
            modifier = modifier.height(16.dp)
        )

        Button(
            onClick = {  },
            content = {
                Text("Submit")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = RectangleShape,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 16.dp)
                .padding(8.dp)
        )
    }


}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){
    DetailScreen(
        vocabData = VocabData(
            1,
            "test",
            "test",
            "test"
        )
    )
}