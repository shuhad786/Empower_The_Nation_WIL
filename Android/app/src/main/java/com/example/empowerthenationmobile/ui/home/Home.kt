package com.example.empowerthenationmobile.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.empowerthenationmobile.R
import com.example.empowerthenationmobile.ui.theme.OrangeText

@Composable
fun HomeScreen() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.secondary)
  ) {
    // Background image with fixed size and 20% opacity
    Image(
      painter = painterResource(id = R.drawable.ic_logo),
      contentDescription = "Background Logo",
      modifier = Modifier
        .size(width = 400.dp, height = 400.dp)  // set your desired width and height here
        .align(Alignment.Center)                // position image in the center of the Box
        .graphicsLayer { alpha = 0.2f },        // 20% opacity
      contentScale = ContentScale.Crop
    )

    // Content on top of the image
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp, vertical = 24.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      Text(
        text = "Welcome to Empowering the Nation",
        style = MaterialTheme.typography.titleLarge,
        color = OrangeText,
        textAlign = TextAlign.Center
      )

      Text(
        text = "Founded in 2022 by Precious Radebe, Empowering the Nation is a proudly South African initiative dedicated to uplifting domestic workers and gardeners through practical, culturally relevant training.",
        style = MaterialTheme.typography.bodyLarge,
        color = OrangeText,
        textAlign = TextAlign.Center
      )

      Text(
        text = "Our programmes blend traditional wisdom with modern skills, creating opportunities for sustainable employment and personal growth. Whether you're looking for a six-month Learnership or a Short Skills Training Programme, we are here to guide you every step of the way.",
        style = MaterialTheme.typography.bodyMedium,
        color = OrangeText,
        textAlign = TextAlign.Center
      )
    }
  }
}
