package com.example.empowerthenationmobile

import android.graphics.Shader
import android.os.Build
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.empowerthenationmobile.composable_icons.Menu
import com.example.empowerthenationmobile.ui.about.AboutScreen
import com.example.empowerthenationmobile.ui.contact.ContactScreen
import com.example.empowerthenationmobile.ui.forms.CalculatorScreen
import com.example.empowerthenationmobile.ui.forms.FormScreen
import com.example.empowerthenationmobile.ui.home.HomeScreen
import com.example.empowerthenationmobile.ui.sixMonths.SixMonthCoursesPage
import com.example.empowerthenationmobile.ui.sixMonths.course5.SewingScreen
import com.example.empowerthenationmobile.ui.sixMonths.course6.LifeSkillsScreen
import com.example.empowerthenationmobile.ui.sixMonths.course7.FirstAidScreen
import com.example.empowerthenationmobile.ui.sixWeeks.SixWeekCoursesPage
import com.example.empowerthenationmobile.ui.sixWeeks.course1.ChildMindingScreen
import com.example.empowerthenationmobile.ui.sixWeeks.course2.CookingScreen
import com.example.empowerthenationmobile.ui.sixWeeks.course3.LandscapingScreen
import com.example.empowerthenationmobile.ui.sixWeeks.course4.GardenMaintenanceScreen
import com.example.empowerthenationmobile.ui.theme.BrownAccent
import com.example.empowerthenationmobile.ui.theme.EmpowerTheNationMobileTheme
import com.example.empowerthenationmobile.ui.theme.OrangeText
import com.example.empowerthenationmobile.ui.theme.Transparent
import com.example.empowerthenationmobile.ui.theme.blurBackground
import android.graphics.RenderEffect as AndroidRenderEffect


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

  // menu height and width between top bar and footer
  val windowInfo = LocalWindowInfo.current
  val density = LocalDensity.current
  val containerHeightDp = with(density) { windowInfo.containerSize.height.toDp() }
  val topBarHeight = 110.dp
  val bottomBarHeight = 250.dp  // adjust if your BottomAppBar height differs
  val dropdownHeight = containerHeightDp - topBarHeight - bottomBarHeight

  Scaffold(
    topBar = {
      TopAppBar(
        modifier = Modifier.height(topBarHeight),
        title = {
          Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
          ) {
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
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
              )
            }
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = MaterialTheme.colorScheme.primary
        ),
        actions = {
          Box {
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
                .blurBackground(20f),  // <-- replace graphicsLayer block with this
              offset = DpOffset(x = 0.dp, y = 31.dp),
              containerColor = BrownAccent.copy(alpha = 0.7f),
              tonalElevation = 0.dp,
              shadowElevation = 0.dp,
              shape = RectangleShape
            ) {
              val menuItems = listOf(
                "Home" to "home",
                "About" to "about",
                "Six Month Course" to "sixMonths",
                "Six Week Course" to "sixWeeks",
                "Contact" to "contact",
                "Forms" to "forms",
                "Calculator" to "calculator"
              )

              Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(0.dp),
                horizontalAlignment = Alignment.CenterHorizontally
              ) {
                menuItems.forEachIndexed { index, (label, route) ->
                  DropdownMenuItem(
                    modifier = Modifier
                      .fillMaxWidth()
                      .blurBackground(20f)
                      .background(BrownAccent.copy(alpha = 0.4f))  // semi-transparent brown tint
                      .drawBehind {
                        if (index < menuItems.size - 1) {
                          val strokeWidth = 3.dp.toPx()
                          drawLine(
                            color = BrownAccent.copy(alpha = 0.8f),
                            start = androidx.compose.ui.geometry.Offset(0f, size.height - strokeWidth / 2),
                            end = androidx.compose.ui.geometry.Offset(size.width, size.height - strokeWidth / 2),
                            strokeWidth = strokeWidth
                          )
                        }
                      }
                      .padding(vertical = 12.dp),
                    onClick = {
                      expanded = false
                      navController.navigate(route) {
                        launchSingleTop = true
                        restoreState = true
                      }
                    },
                    text = {
                      Box(
                        modifier = Modifier
                          .fillMaxWidth()
                          .graphicsLayer {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                              renderEffect = AndroidRenderEffect.createBlurEffect(
                                20f, 20f, Shader.TileMode.CLAMP
                              ).asComposeRenderEffect()
                            }
                          }
                          .background(Color.Transparent),  // or a semi-transparent color if you want tint
                        contentAlignment = Alignment.Center,
                      ) {
                        Text(
                          text = label,
                          color = OrangeText,
                          textAlign = TextAlign.Center,
                          style = MaterialTheme.typography.titleLarge
                        )
                      }
                    }
                  )
                }
              }
            }  // dropdown end
          }
        }
      )
    },
    bottomBar = { // footer
      Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
          .fillMaxWidth()
          .heightIn(min = 100.dp, max = 250.dp)  // max height to limit size
          .verticalScroll(rememberScrollState())
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
          verticalAlignment = Alignment.Top,
          horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
          // Left side: FAQS and SPONSORS stacked vertically
          Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start
          ) {
            // FAQS section
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
              Text(
                text = "FAQS",
                fontSize = 14.sp,
                color = OrangeText,
                style = MaterialTheme.typography.bodyMedium
              )
              listOf("Payments", "Registration", "Employment").forEach { item ->
                Row {
                  Text(text = "• ", color = OrangeText, fontSize = 14.sp)
                  Text(text = item, color = OrangeText, fontSize = 10.sp)
                }
              }
            }

            // SPONSORS section below FAQS
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
              Text(
                text = "SPONSORS",
                fontSize = 14.sp,
                color = OrangeText,
                style = MaterialTheme.typography.bodyMedium
              )
              listOf(
                "Elevate Workforce Foundation",
                "Pathway Advancement Initiative",
                "NextGen Skills Alliance",
                "Empowerment Futures Trust"
              ).forEach { item ->
                Row {
                  Text(text = "• ", color = OrangeText, fontSize = 14.sp)
                  Text(text = item, color = OrangeText, fontSize = 10.sp)
                }
              }
            }
          }

          // Right side: Button and subscription text inside a bubble, plus footer text below
          Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Surface(
              shape = RoundedCornerShape(16.dp),
              color = BrownAccent,
              modifier = Modifier
                .padding(16.dp)  // padding to give shadow space
                .shadow(
                  elevation = 16.dp,  // stronger shadow
                  shape = RoundedCornerShape(16.dp),
                  clip = false
                )
            ) {
              Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
              ) {
                Button(
                  onClick = { /* Enquire action */ },
                  shape = RoundedCornerShape(10.dp),
                  colors = ButtonDefaults.buttonColors(containerColor = Transparent)
                ) {
                  Text(
                    text = "Enquire",
                    color = OrangeText,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium
                  )
                }

                Text(
                  text = "Subscribe to our news letter for more information on availability for 2025 Courses.",
                  color = OrangeText,
                  textAlign = TextAlign.Center,
                  style = MaterialTheme.typography.titleSmall
                )
              }
            }
          }            // bubble end
        }
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
      composable("sixWeeks") { SixWeekCoursesPage() }
      composable("contact") { ContactScreen() }
      composable("forms") { FormScreen() }
      composable("calculator") { CalculatorScreen() }
        composable("sixMonths") { SixMonthCoursesPage(navController = navController) }//added these so i can view the pages on click
        composable("firstAid") { FirstAidScreen(navController = navController) }
        composable("sewing") { SewingScreen(navController = navController) }
        composable("landscaping") { LandscapingScreen(navController = navController) }
        composable("lifeSkills") { LifeSkillsScreen(navController = navController) }
        composable("cooking") { CookingScreen(navController = navController) }
        composable("childminding") { ChildMindingScreen(navController = navController) }
        composable("gardenmaintenance") { GardenMaintenanceScreen(navController = navController) }
      }

    }
  }


@Preview(showBackground = true)
@Composable
fun EmpowerTheNationAppPreview() {
  EmpowerTheNationApp()
}