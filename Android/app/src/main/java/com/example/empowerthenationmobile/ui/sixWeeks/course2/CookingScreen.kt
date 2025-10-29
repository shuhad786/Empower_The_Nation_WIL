package com.example.empowerthenationmobile.ui.sixWeeks.course2

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
fun CookingScreen (navController: NavController? = null) {
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
        .verticalScroll(rememberScrollState())  // <-- makes it scrollable
        .wrapContentHeight(),
      horizontalAlignment = Alignment.Start,
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      Text(
        text = "Cooking",
        fontSize = 22.sp,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold
      )

      Text(
        text = "Learn to cook and prepare nutritious family meals.",
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
        Text("• Nutritional requirements for a healthy body")
        Text("• Types of proteins, carbs, and vegetables")
        Text("• Planning meals")
        Text("• Tasty and nutritious recipes")
        Text("• Preparation and cooking of meals")
      }

      Text(
        text = "Course Fee: R750",
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
fun PreviewCookingScreen() {
  CookingScreen()
}
