package com.unisabana.wordle.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class CellType{
    GREEN,
    YELLOW,
    GREY,
    TRANSPARENT
}

@Composable
fun Cell(character: String, blockType:CellType){

    val backgroundColor = when (blockType){
        CellType.YELLOW -> Color(0xFFC9B457)
        CellType.GREEN -> Color(0xFF6AAA65)
        CellType.GREY -> Color(0xFF787C7F)
        else -> Color.Transparent
    }

    Box(
        modifier = Modifier
            .size(50.dp)
            .background(backgroundColor, shape = RoundedCornerShape(2.dp)),
        contentAlignment = Alignment.Center
    ) { // -> Container -> div
        Text(character, fontSize = 26.sp, color = Color.White) // dp -> sp
    }
}

@Composable
fun RowCell (text:String){
    Row{
        for(c in text){
            val color = checkColor('T', c.toString())
            Cell(c.toString(),color )
        }
    }
}

@Composable
fun Grid(solution: String, currentWord: String, attempts: List<String>) {
    for(i in 0..6){
        RowCell("     ")
    }
}

fun checkColor(a:Char, b:String):CellType{
    return CellType.GREEN
}

@Preview
@Composable
fun PreviewCellSuccess(){
    Column {
        RowCell("Hello")
        RowCell("Hello")
        RowCell("Hello")
        RowCell("Hello")
        RowCell("Hello")
    }
}



//
//@Preview
//@Composable
//fun PreviewCellMissing(){
//    Cell("W", 0)
//}
//
//@Preview
//@Composable
//fun PreviewCellNoInWord(){
//    Cell("W", 2)
//}

// "basd" -> String
// 'a' -> Char


// String -> Char[]

// Hola -> H,O,L,A .toString()