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

// Lose Screen – displayed when the player gives a wrong answer
class LoseScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoseScreenUI(
                onTryAgain = {
                    // When "Try Again" is clicked, restart the quiz from the main screen
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            )
        }
    }


}

@Composable
fun LoseScreenUI(onTryAgain: () -> Unit) {
// Background layout with dark red color to indicate losing state
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF5C0000)), // Deep red color for loss theme
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {


            //  Main title for losing message
            Text(
                text = "😢 You Lost!",
                color = Color.Yellow,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Encouragement text
            Text(
                text = "Better luck next time!",
                color = Color.White,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(40.dp))


            Button(onClick = onTryAgain) {
                Text("Try Again")
            }
        }
    }

}
