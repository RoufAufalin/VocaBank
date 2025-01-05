package com.aupal.vocabank.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aupal.vocabank.ui.theme.InterFamily

@Composable
fun SectionText(
    title: String,
    modifier: Modifier = Modifier,
){
        Text(
            text = title,
            fontFamily = InterFamily,
            fontWeight = FontWeight.Normal,
            modifier = modifier
                .padding(vertical = 8.dp)
        )
}

@Preview(showBackground = true)
@Composable
fun SectionTextPreview(){
    SectionText("Section Text")
}
