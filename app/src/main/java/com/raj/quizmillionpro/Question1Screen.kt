package com.raj.quizmillionpro

import android.content.Intent
import android.os.Bundle
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

class Question1Screen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuestionOneUI(
                onCorrect = {
                    Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, Question2Screen::class.java))
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
fun QuestionOneUI(onCorrect: () -> Unit, onWrong: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF011F4B)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Question 1: What is the capital of France?", // Displaying the question text
                color = Color.White,
                fontSize = 22.sp,
                modifier = Modifier.padding(16.dp)
            )


            Spacer(modifier = Modifier.height(20.dp))

            // Only option B is correct
            Button(onClick = onWrong) { Text("A) Madrid") }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = onCorrect) { Text("B) Paris") }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = onWrong) { Text("C) Rome") }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = onWrong) { Text("D) Berlin") }
        }
    }


}
