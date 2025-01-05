package com.aupal.vocabank.ui.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aupal.vocabank.ui.component.SectionText
import com.aupal.vocabank.ui.theme.VocabankTheme

@Composable
fun AddScreen(
    modifier : Modifier = Modifier
){
    var vocab by remember{ mutableStateOf(TextFieldValue("")) }
    var meaning by remember{ mutableStateOf(TextFieldValue("")) }
    var example by remember{ mutableStateOf(TextFieldValue("")) }


    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        SectionText("English Vocabulary")
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth(),
            value = vocab,
            onValueChange = { newText ->
                vocab = newText
            }
        )

        SectionText("Indonesian Meaning")
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth(),
            value = meaning,
            onValueChange = { newText ->
                meaning = newText
            }
        )

        SectionText("Example Sentence")
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .height(120.dp),
            maxLines = 5,
            value = example,
            onValueChange = { newText ->
                example = newText
            }
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
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AddScreenPreview(){
        AddScreen()
}