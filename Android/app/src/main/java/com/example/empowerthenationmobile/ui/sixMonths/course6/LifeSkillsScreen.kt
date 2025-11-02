package com.example.empowerthenationmobile.ui.sixMonths.course6

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.empowerthenationmobile.R
import com.example.empowerthenationmobile.ui.theme.BrownAccent
import com.example.empowerthenationmobile.ui.theme.OrangeText

@Composable
fun LifeSkillsScreen(navController: NavController? = null) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)
      .clip(RoundedCornerShape(16.dp))
      .background(BrownAccent.copy(alpha = 0.85f))
  ) {
    // Background image with 20% opacity, centered
    Image(
      painter = painterResource(id = R.drawable.ic_logo),
      contentDescription = "Background Logo",
      modifier = Modifier
        .size(width = 400.dp, height = 400.dp)
        .align(Alignment.Center)
        .graphicsLayer { alpha = 0.2f },
      contentScale = ContentScale.Crop
    )

    // Foreground content
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
        .verticalScroll(rememberScrollState())
        .wrapContentHeight(),
      horizontalAlignment = Alignment.Start,
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      Column(modifier = Modifier.padding(20.dp)) {

        Text(
          text = "Life Skills",
          fontSize = 22.sp,
          color = OrangeText,
          fontWeight = FontWeight.Bold
        )

        Text(
          text = "Learn essential life skills to navigate basic life necessities.",
          fontSize = 16.sp,
          color = OrangeText
        )

        Text(
          text = "You will learn:",
          fontSize = 16.sp,
          color = OrangeText,
          fontWeight = FontWeight.SemiBold
        )

        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
          Text("• Opening a bank account", color = OrangeText)
          Text("• Basic labour law (know your rights)", color = OrangeText)
          Text("• Basic reading and writing literacy", color = OrangeText)
          Text("• Basic numeric literacy", color = OrangeText)
        }

        Text(
          text = "Course Fee: R1500",
          fontSize = 16.sp,
          color = OrangeText,
          fontWeight = FontWeight.Bold
        )

        Button(
          onClick = { navController?.popBackStack() },
          shape = RoundedCornerShape(12.dp),
          colors = ButtonDefaults.buttonColors(containerColor = OrangeText.copy(alpha = 0.1f)),
          modifier = Modifier.padding(top = 8.dp)
        ) {
          Text(text = "⬅ Back to Course List", color = OrangeText)
        }
      }
    }
  }
}
