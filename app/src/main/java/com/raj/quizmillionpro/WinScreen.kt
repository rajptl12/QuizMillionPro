package com.raj.quizmillionpro

import android.content.Intent
import android.os.Bundle
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

//  Win Screen  displayed when the player answers all questions correctly
class WinScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            WinScreenUI(
                onPlayAgain = {
                    // When "Play Again" is clicked, restart the quiz from MainActivity
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            )
        }
    }


}

@Composable
fun WinScreenUI(onPlayAgain: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF004D00)), // Green background for success
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            //  Main title
            Text(
                text = "🎉 Congratulations! 🎉",
                color = Color.Yellow,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "You are a Millionaire! 💰",
                color = Color.White,
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Button to restart the game
            Button(onClick = onPlayAgain) {
                Text("Play Again")
            }
        }
    }


}
