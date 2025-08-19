package com.unisabana.wordle.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlin.text.iterator

@Composable
fun Key(char: Char, onPress: (char: Char) -> Unit, onRemove: () -> Unit){
    Text(char.toString(), modifier = Modifier.clickable {
        if(char == '«'){
            onRemove()
        }else{
            onPress(char)
        }
    })
}

@Composable
fun KeyRow(row:String, onRemove: () -> Unit,
           onKeyPressed: (Char) -> Unit){
    Row {
        for(char in row){
            Key(char, onKeyPressed, onRemove)
        }
    }
}

@Composable
fun Keyboard(onRemove: () -> Unit,
             onKeyPressed: (Char) -> Unit) {
    val rows = listOf<String>("qwertyuiop", "asdfghjkl", "zxcvbnm«")

    Column {
        for(row in rows){
            KeyRow(row, onRemove, onKeyPressed)

        }
    }

}