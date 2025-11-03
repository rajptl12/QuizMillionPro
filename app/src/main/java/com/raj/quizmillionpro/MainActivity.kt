package com.raj.quizmillionpro

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen(
                onStart = {
                    // 👉 When Start Quiz button is clicked, open the first question screen
                    startActivity(Intent(this, Question1Screen::class.java))
                    // 🚪 Close this activity so user can’t go back to splash screen
                    finish()
                }
            )
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(onStart: () -> Unit) {
// Full screen layout with background color and center alignment
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF011F4B)), // blue background
        contentAlignment = Alignment.Center
    ) {
//  logo, title, and button
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            //  Displaying the app logo inside a Card with rounded corners and shadow
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                modifier = Modifier
                    .size(150.dp)
                    .padding(bottom = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.app_logo), // App logo from res/drawable
                    contentDescription = "App Logo",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            // App Title
            Text(
                text = "🎯 Quiz Million Pro 🎯",
                color = Color.White,
                fontSize = 26.sp,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Start Button (navigates to first quiz question)
            Button(
                onClick = onStart,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7E57C2))
            ) {
                Text("Start Quiz")
            }
        }
    }


}
