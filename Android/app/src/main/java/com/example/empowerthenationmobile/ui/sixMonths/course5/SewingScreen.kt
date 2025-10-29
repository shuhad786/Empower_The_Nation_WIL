package com.example.empowerthenationmobile.ui.sixMonths.course5

import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SewingScreen(navController: NavController? = null) {
  Surface(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    color = MaterialTheme.colorScheme.surface
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .wrapContentHeight(),
      horizontalAlignment = Alignment.Start,
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      Text(
        text = "Sewing",
        fontSize = 22.sp,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold
      )

      Text(
        text = "Learn to provide garments and offer new garment tailoring services in this six-month course.",
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.onSurface
      )

      Text(
        text = "You will learn:",
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.onSurface,
        fontWeight = FontWeight.SemiBold
      )

      Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text("• Types of stitches")
        Text("• Threading a sewing machine")
        Text("• Sewing buttons, hems, zips, and seams")
        Text("• Alterations")
        Text("• Designing and sewing new garments")
      }

      Text(
        text = "Course Fee: R1500",
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold
      )

      Button(
        onClick = { navController?.popBackStack() },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.padding(top = 8.dp)
      ) {
        Text(text = "⬅ Back to Course List")
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun PreviewSewingScreen() {
  SewingScreen()
}
