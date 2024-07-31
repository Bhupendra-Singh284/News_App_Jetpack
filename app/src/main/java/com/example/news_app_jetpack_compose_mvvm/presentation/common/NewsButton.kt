package com.example.news_app_jetpack_compose_mvvm.presentation.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun NewsButton(
    text:String,
    onClick:()->Unit

) {
    Button(
        modifier=Modifier.padding(horizontal = 10.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
    ,   shape = RoundedCornerShape(6.dp)
    ) {
        Text(text, style=MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold))
    }
}
@Composable
fun NewsTextButton(
    text:String,
    onClick:()->Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    ,   shape = RoundedCornerShape(6.dp)
    ) {
        Text(text,
            style=MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold))
    }
}