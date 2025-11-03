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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Question10Screen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalQuestionUI(
                onRightOption = {
                    Toast.makeText(this, "Correct! You’re a Millionaire! 🏆", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, WinScreen::class.java))
                    finish()
                },
                onWrongOption = {
                    Toast.makeText(this, "Oops! That was incorrect 😞", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoseScreen::class.java))
                    finish()
                }
            )
        }
    }
}

@Composable
fun FinalQuestionUI(onRightOption: () -> Unit, onWrongOption: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0B132B)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Question 10: Which planet is known as the Red Planet?",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = onWrongOption) { Text("A) Venus") }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = onRightOption) { Text("B) Mars") }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = onWrongOption) { Text("C) Jupiter") }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = onWrongOption) { Text("D) Mercury") }
        }
    }
}
