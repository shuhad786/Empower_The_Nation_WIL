package com.example.empowerthenationmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
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
import com.example.empowerthenationmobile.ui.theme.BrownAccent
import com.example.empowerthenationmobile.ui.theme.EmpowerTheNationMobileTheme
import com.example.empowerthenationmobile.ui.theme.OrangeText


class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      EmpowerTheNationMobileTheme(dynamicColor = false) {
        EmpowerTheNationApp()
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmpowerTheNationApp() {
  val navController = rememberNavController()
  var expanded by remember { mutableStateOf(false) }  // Dropdown menu visibility state

  // shadow values for the Logo
  val shadowColor = Color(0xFF000000)  // black
  val shadowAlpha = 1f  // 100% opacity
  val shadowBlurRadius = 15.dp
  val shadowOffsetX = 4.dp
  val shadowOffsetY = 4.dp

  // adjust height of the drop down menu
  val heightDensity = LocalDensity.current
  val yOffsetPx = with(heightDensity) { 10.dp.roundToPx() }  // adjust 10.dp to how far down you want

  // menu height and width between top bar and footer
  val windowInfo = LocalWindowInfo.current
  val density = LocalDensity.current
  val containerHeightDp = with(density) { windowInfo.containerSize.height.toDp() }
  val topBarHeight = 110.dp
  val bottomBarHeight = 210.dp  // adjust if your BottomAppBar height differs
  val dropdownHeight = containerHeightDp - topBarHeight - bottomBarHeight

  Scaffold(
    topBar = {
      TopAppBar(
        modifier = Modifier.height(topBarHeight),
        title = {

          Row (
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround)
          {
            Box(
              modifier = Modifier
                .size(80.dp)
                .drawBehind {
                  drawIntoCanvas { canvas ->
                    val paint = Paint().asFrameworkPaint().apply {
                      isAntiAlias = true
                      color = shadowColor.copy(alpha = shadowAlpha).toArgb()
                      setShadowLayer(
                        shadowBlurRadius.toPx(),
                        shadowOffsetX.toPx(),
                        shadowOffsetY.toPx(),
                        color
                      )
                    }
                    canvas.nativeCanvas.drawCircle(
                      size.width / 2,
                      size.height / 2,
                      size.minDimension / 2,
                      paint
                    )
                  }
                }
                .clip(CircleShape)
            ) {
              Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "App Logo",
                modifier = Modifier.fillMaxSize()
              )
            }
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = MaterialTheme.colorScheme.primary
        ),
        actions = {
          Box  {
            IconButton(onClick = { expanded = true }) {
              Icon (
                Menu,
                contentDescription = "Menu",
                tint = OrangeText,
                modifier = Modifier.size(40.dp)
                )
            }
            DropdownMenu(
              expanded = expanded,
              onDismissRequest = { expanded = false },
              modifier = Modifier
                .fillMaxWidth()
                .height(dropdownHeight)
                .background(BrownAccent.copy(alpha = 0.9f)),

              offset = DpOffset(x = 0.dp, y = 20.dp)  // moves dropdown
            ) {
              Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(40.dp),  // even vertical spacing
                horizontalAlignment = Alignment.CenterHorizontally  // center items horizontally
              ) {
                DropdownMenuItem(
                  text = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                      Text("Home", color = OrangeText)
                    }
                  },
                  onClick = {
                    expanded = false
                    navController.navigate("home") {
                      launchSingleTop = true
                      restoreState = true
                    }
                  }
                )
                DropdownMenuItem(
                  text = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                      Text("About", color = OrangeText)
                    }
                  },
                  onClick = {
                    expanded = false
                    navController.navigate("about") {
                      launchSingleTop = true
                      restoreState = true
                    }
                  }
                )
                DropdownMenuItem(
                  text = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text("Six Month Course", color = OrangeText)
                    }
                  },
                  onClick = {
                    expanded = false
                    navController.navigate("sixMonths") {
                      launchSingleTop = true
                      restoreState = true
                    }
                  }
                )
                DropdownMenuItem(
                  text = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text("Six Week Course", color = OrangeText)
                    }
                  },
                  onClick = {
                    expanded = false
                    navController.navigate("sixWeeks") {
                      launchSingleTop = true
                      restoreState = true
                    }
                  }
                )
                DropdownMenuItem(
                  text = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text("Contact", color = OrangeText)
                    }
                  },
                  onClick = {
                    expanded = false
                    navController.navigate("contact") {
                      launchSingleTop = true
                      restoreState = true
                    }
                  }
                )
                DropdownMenuItem(
                  text = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text("Forms", color = OrangeText)
                    }
                  },
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
        }
      )
    },
    bottomBar = {
      BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primary, // GreenAccent background
        modifier = Modifier.height(200.dp)
      ) {
        Text(
          modifier = Modifier.padding(16.dp),
          text = "Static Footer",
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onPrimary
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