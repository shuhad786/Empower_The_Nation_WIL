package com.example.empowerthenationmobile.ui.sixMonths

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Course(
  val id: String,       // NavController route
  val title: String,
  val description: String
)

@Composable
fun SixMonthCoursesPage(navController: NavController) {
  val courses = listOf(
    Course("firstAid", "First Aid", "Learn essential first aid awareness and basic life support."),
    Course("sewing", "Sewing", "Learn to provide garments and new garment tailoring services."),
    Course("landscaping", "Landscaping", "Learn landscaping servicing for new and established gardens."),
    Course("lifeSkills", "Life Skills", "Learn essential life skills for personal and professional development.")
  )

  Scaffold { padding ->
    Column(
      modifier = Modifier
        .padding(padding)
        .fillMaxSize()
        .padding(horizontal = 16.dp)
    ) {
      Spacer(modifier = Modifier.height(12.dp))

      Text(
        text = "Six Month Courses",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.align(Alignment.CenterHorizontally)
      )

      Text(
        text = "Our six-month courses provide in-depth, hands-on training and professional development opportunities.",
        fontSize = 14.sp,
        color = MaterialTheme.colorScheme.primary,
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
            // Navigate to the individual course screen
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
    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 8.dp)
  ) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.padding(16.dp)
    ) {
      Text(
        text = course.title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
      )

      Text(
        text = course.description,
        fontSize = 14.sp,
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(vertical = 8.dp)
      )

      Button(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp)
      ) {
        Text("View Details")
      }
    }
  }
}
