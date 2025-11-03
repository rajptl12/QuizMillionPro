package com.raj.quizmillionpro

import android.content.Intent
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.os.Bundle

class Question7Screen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuestionSevenUI(
                onCorrect = {
                    Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, Question8Screen::class.java))
                    finish()
                },
                onWrong = {
                    Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoseScreen::class.java))
                    finish()
                }
            )
        }
    }
}

@Composable
fun QuestionSevenUI(onCorrect: () -> Unit, onWrong: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF011F4B)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Question 7: What is the square root of 64?",
                color = Color.White,
                fontSize = 22.sp,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = onCorrect) { Text("A) 8") }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = onWrong) { Text("B) 6") }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = onWrong) { Text("C) 7") }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = onWrong) { Text("D) 9") }
        }
    }
}
