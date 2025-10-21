package com.example.empowerthenationmobile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.empowerthenationmobile.composable_icons.Menu
import com.example.empowerthenationmobile.ui.about.AboutScreen
import com.example.empowerthenationmobile.ui.contact.ContactScreen
import com.example.empowerthenationmobile.ui.forms.FormScreen
import com.example.empowerthenationmobile.ui.home.HomeScreen
import com.example.empowerthenationmobile.ui.sixMonths.SixMonthScreen
import com.example.empowerthenationmobile.ui.sixWeeks.SixWeekScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmpowerTheNationApp() {
  val navController = rememberNavController()
  var expanded by remember { mutableStateOf(false) }  // Dropdown menu visibility state

  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Empower The Nation") },
        actions = {
          Box {
            IconButton(onClick = { expanded = true }) {
              Icon(Menu, contentDescription = "Menu")
            }
            DropdownMenu(
              expanded = expanded,
              onDismissRequest = { expanded = false }
            ) {
              DropdownMenuItem(
                text = { Text("Home") },
                onClick = {
                  expanded = false
                  navController.navigate("home") {
                    launchSingleTop = true
                    restoreState = true
                  }
                }
              )
              DropdownMenuItem(
                text = { Text("About") },
                onClick = {
                  expanded = false
                  navController.navigate("about") {
                    launchSingleTop = true
                    restoreState = true
                  }
                }
              )
              DropdownMenuItem(
                text = { Text("Six Month Course") },
                onClick = {
                  expanded = false
                  navController.navigate("sixMonths") {
                    launchSingleTop = true
                    restoreState = true
                  }
                }
              )
              DropdownMenuItem(
                text = { Text("Six Week Course") },
                onClick = {
                  expanded = false
                  navController.navigate("sixWeeks") {
                    launchSingleTop = true
                    restoreState = true
                  }
                }
              )
              DropdownMenuItem(
                text = { Text("Contact") },
                onClick = {
                  expanded = false
                  navController.navigate("contact") {
                    launchSingleTop = true
                    restoreState = true
                  }
                }
              )
              DropdownMenuItem(
                text = { Text("Forms") },
                onClick = {
                  expanded = false
                  navController.navigate("forms") {
                    launchSingleTop = true
                    restoreState = true
                  }
                }
              )
            }
          }
        }
      )
    },
    bottomBar = {
      BottomAppBar {
        Text(
          modifier = Modifier.padding(16.dp),
          text = "Static Footer",
          style = MaterialTheme.typography.bodyMedium
        )
      }
    }
  ) { innerPadding ->
    NavHost(
      navController = navController,
      startDestination = "home",
      modifier = Modifier.padding(innerPadding)
    ) {
      composable("home") { HomeScreen() }
      composable("about") { AboutScreen() }
      composable("sixMonths") { SixMonthScreen() }
      composable("sixWeeks") { SixWeekScreen() }
      composable("contact") { ContactScreen() }
      composable("forms") { FormScreen() }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun EmpowerTheNationAppPreview() {
  EmpowerTheNationApp()
}