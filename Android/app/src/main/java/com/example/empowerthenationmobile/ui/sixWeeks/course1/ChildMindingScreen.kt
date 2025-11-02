package com.example.empowerthenationmobile.ui.sixWeeks.course1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
fun ChildMindingScreen(navController: NavController? = null) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)
      .clip(RoundedCornerShape(16.dp))
      .background(BrownAccent.copy(alpha = 0.85f))
  ) {
    // Background logo
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
          text = "Child Minding",
          fontSize = 22.sp,
          color = OrangeText,
          fontWeight = FontWeight.Bold
        )

        Text(
          text = "Learn how to provide safe basic child and baby care during this six-week course.",
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
          Text("• Birth to six-month-old baby needs", color = OrangeText)
          Text("• Seven month to one-year-old baby needs", color = OrangeText)
          Text("• Toddler needs and educational toys", color = OrangeText)
        }

        Text(
          text = "Course Fee: R750",
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
