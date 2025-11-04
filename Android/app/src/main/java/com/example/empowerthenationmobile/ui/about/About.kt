package com.example.empowerthenationmobile.ui.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.empowerthenationmobile.R

@Composable
fun AboutScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F0E0))
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_logo),
            contentDescription = "Watermark Logo",
            modifier = Modifier
                .size(550.dp)
                .align(Alignment.Center)
                .offset(y = 50.dp),
            contentScale = ContentScale.Fit,
            alpha = 0.15f
        )

        // Content overlay
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Founded in 2022 by Precious Radebe, Empowering the Nation is a proudly South African initiative dedicated to uplifting domestic workers and gardeners through practical, culturally relevant training.",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFD97D2E), // Orange color
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Our programmes blend traditional wisdom with modern skills, creating opportunities for sustainable employment and personal growth. Whether you're looking for a six-month Learnership or a Short Skills Training Programme, we are here to guide you every step of the way.",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFD97D2E),
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "We believe in the power of community and the dignity of work. By equipping individuals with valuable life and work skills, we help unlock doors to brighter futures for families and communities.",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFD97D2E),
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Together with our partners and supporters, we strive to foster resilience, confidence, and lasting change in the lives of those we serve. Our vision is a nation where every worker is empowered, respected, and given opportunities to thrive.",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFD97D2E),
                textAlign = TextAlign.Left
            )
        }
    }
}