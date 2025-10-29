package com.example.empowerthenationmobile.ui.sixMonths.course7

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
fun FirstAidScreen(navController: NavController? = null) {
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
        text = "First Aid",
        fontSize = 22.sp,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold
      )

      Text(
        text = "Learn essential first aid awareness and basic life support in this six-month course.",
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
        Text("• Wounds and bleeding")
        Text("• Burns and fractures")
        Text("• Emergency scene management")
        Text("• Cardio-Pulmonary Resuscitation (CPR)")
        Text("• Respiratory distress e.g. choking or blocked airway")
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
fun PreviewFirstAidScreen() {
  FirstAidScreen()
}
