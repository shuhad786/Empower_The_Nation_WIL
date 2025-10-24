package com.example.empowerthenationmobile.ui.sixWeeks

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.empowerthenationmobile.R

data class Course(
  val title: String,
  val description: String
)

@Composable
fun SixWeekCoursesPage() {
  val courses = listOf(
    Course("Child Minding", "Learn how to provide safe basic child and baby care."),
    Course("Cooking", "Learn to cook and prepare nutritious family meals."),
    Course("Garden Maintenance", "Learn the basics of watering, planting, and pruning.")
  )

  Scaffold(
    topBar = { TopNavBar() },
    bottomBar = { FooterSection() }
  ) { padding ->
    Column(
      modifier = Modifier
        .padding(padding)
        .fillMaxSize()
        .padding(horizontal = 16.dp)
    ) {
      Spacer(modifier = Modifier.height(12.dp))

      Text(
        text = "Six Week Courses",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.align(Alignment.CenterHorizontally)
      )

      Text(
        text = "Each course runs for six weeks and offers practical, hands-on skills development.",
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
          CourseCard(course)
        }
      }
    }
  }
}

@Composable
fun CourseCard(course: Course) {
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
        onClick = { /* Navigate to details page */ },
        shape = RoundedCornerShape(12.dp)
      ) {
        Text("View Details")
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar() {
  TopAppBar(
    title = {
      Text(
        "Empower The Nation",
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
      )
    },
    navigationIcon = {
      Image(
        painter = painterResource(id = R.drawable.ic_logo), // logo ref
        contentDescription = "Logo",
        modifier = Modifier
          .size(40.dp)
          .padding(start = 8.dp)
      )
    }
  )
}

@Composable
fun FooterSection() {
  Surface(
    color = MaterialTheme.colorScheme.secondaryContainer,
    tonalElevation = 4.dp
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = "2025 Empowering the Nation.\nAll rights reserved.",
        fontSize = 12.sp,
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Center
      )

      Spacer(modifier = Modifier.height(8.dp))

      Button(
        onClick = { /* Enquire action */ },
        shape = RoundedCornerShape(10.dp)
      ) {
        Text("Enquire")
      }
    }
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SixWeekCoursesPreview() {
  MaterialTheme {
    SixWeekCoursesPage()
  }
}