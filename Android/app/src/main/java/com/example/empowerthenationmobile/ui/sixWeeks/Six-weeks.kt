package com.example.empowerthenationmobile.ui.sixWeeks

import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.empowerthenationmobile.ui.theme.BrownAccent
import com.example.empowerthenationmobile.ui.theme.OrangeText

data class Course(
  val id: String,
  val title: String,
  val description: String
)

@Composable
fun SixWeekCoursesPage(navController: NavController) {
  val courses = listOf(
    Course("childminding", "Child Minding", "Learn how to provide safe basic child and baby care."),
    Course("cooking", "Cooking", "Learn to cook and prepare nutritious family meals."),
    Course("gardenmaintenance", "Garden Maintenance", "Learn the basics of watering, planting, and pruning.")
  )

  Scaffold(
    containerColor = (MaterialTheme.colorScheme.secondary) // Transparent background for the page
  ) { padding ->
    Column(
      modifier = Modifier
        .padding(padding)
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.secondary)//
        .padding(horizontal = 16.dp)
    ) {
      Spacer(modifier = Modifier.height(12.dp))

      Text(
        text = "Six Week Courses",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = OrangeText,
        modifier = Modifier.align(Alignment.CenterHorizontally)
      )

      Text(
        text = "Each course runs for six weeks and offers practical, hands-on skills development.",
        fontSize = 14.sp,
        color = OrangeText,
        textAlign = TextAlign.Center,
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 8.dp)
      )

      LazyColumn(
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        items(courses) { course ->
          CourseCard(course = course) {
            navController.navigate(course.id)
          }
        }
      }
    }
  }
}

@Composable
fun CourseCard(course: Course, onClick: () -> Unit) {
  Card(
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(
      containerColor = BrownAccent.copy(alpha = 0.85f)
    ),
    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 8.dp)
  ) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .padding(16.dp)
    ) {
      Text(
        text = course.title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = OrangeText
      )

      Text(
        text = course.description,
        fontSize = 14.sp,
        color = OrangeText,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(vertical = 8.dp)
      )

      Button(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = OrangeText.copy(alpha = 0.1f))
      ) {
        Text(
          text = "View Details",
          color = OrangeText
        )
      }
    }
  }
}
