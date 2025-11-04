package com.example.empowerthenationmobile.ui.forms

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.empowerthenationmobile.R

@Composable
fun FormScreen(modifier: Modifier = Modifier) {
  val primaryColor = Color(0xFFCB7318)
  val backgroundColor = Color(0xFFF5F5F5)
  val inputBgColor = Color(0x0F000000)

  var lastName by remember { mutableStateOf(TextFieldValue()) }
  var firstName by remember { mutableStateOf(TextFieldValue()) }
  var email by remember { mutableStateOf(TextFieldValue()) }
  var phone by remember { mutableStateOf(TextFieldValue()) }
  var title by remember { mutableStateOf(TextFieldValue()) }
  var issueDetails by remember { mutableStateOf(TextFieldValue()) }
  var leadDetails by remember { mutableStateOf(TextFieldValue()) }

  Column(
    modifier = modifier
      .fillMaxSize()
      .background(backgroundColor)
      .verticalScroll(rememberScrollState())
      .padding(horizontal = 16.dp, vertical = 24.dp)
  ) {
    // Title
    Text(
      text = "SUBMISSION FORM",
      fontSize = 24.sp,
      fontWeight = FontWeight.Bold,
      color = Color.Black,
      modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 32.dp),
      textAlign = androidx.compose.ui.text.style.TextAlign.Center
    )

    // Personal Details Section
    FormSection(
      title = "Personal Details",
      primaryColor = primaryColor
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        FormInputField(
          value = lastName,
          onValueChange = { lastName = it },
          label = "Last Name",
          placeholder = "Enter Last Name",
          iconRes = R.drawable.user_circle,
          primaryColor = primaryColor,
          backgroundColor = inputBgColor,
          modifier = Modifier.weight(1f)
        )

        FormInputField(
          value = firstName,
          onValueChange = { firstName = it },
          label = "First Name",
          placeholder = "Enter First Name",
          iconRes = R.drawable.user_circle,
          primaryColor = primaryColor,
          backgroundColor = inputBgColor,
          modifier = Modifier.weight(1f)
        )
      }

      Spacer(modifier = Modifier.height(20.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        FormInputField(
          value = email,
          onValueChange = { email = it },
          label = "Email",
          placeholder = "Enter Your Email",
          iconRes = R.drawable.envelope,
          primaryColor = primaryColor,
          backgroundColor = inputBgColor,
          modifier = Modifier.weight(1f)
        )

        FormInputField(
          value = phone,
          onValueChange = { phone = it },
          label = "Phone Number",
          placeholder = "Enter Your Phone Number",
          iconRes = R.drawable.phone,
          primaryColor = primaryColor,
          backgroundColor = inputBgColor,
          modifier = Modifier.weight(1f)
        )
      }
    }

    Spacer(modifier = Modifier.height(40.dp))

    // Issue Details Section
    FormSection(
      title = "Issue Details",
      primaryColor = primaryColor
    ) {
      FormInputField(
        value = title,
        onValueChange = { title = it },
        label = "Title",
        placeholder = "Enter Title",
        iconRes = R.drawable.document,
        primaryColor = primaryColor,
        backgroundColor = inputBgColor,
        modifier = Modifier.fillMaxWidth()
      )

      Spacer(modifier = Modifier.height(20.dp))

      FormTextArea(
        value = issueDetails,
        onValueChange = { issueDetails = it },
        label = "Details",
        placeholder = "Write Anything . . .",
        primaryColor = primaryColor,
        backgroundColor = inputBgColor
      )
    }

    Spacer(modifier = Modifier.height(40.dp))

    Spacer(modifier = Modifier.height(24.dp))
  }
}

@Composable
fun FormSection(
  title: String,
  primaryColor: Color,
  content: @Composable ColumnScope.() -> Unit
) {
  Column {
    SectionTitle(title = title, primaryColor = primaryColor)
    Spacer(modifier = Modifier.height(16.dp))
    content()
  }
}

@Composable
fun SectionTitle(title: String, primaryColor: Color) {
  Text(
    text = title,
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold,
    color = primaryColor,
    modifier = Modifier.padding(bottom = 0.dp)
  )
}

@Composable
fun FormInputField(
  value: TextFieldValue,
  onValueChange: (TextFieldValue) -> Unit,
  label: String,
  placeholder: String,
  @DrawableRes iconRes: Int,
  primaryColor: Color,
  backgroundColor: Color,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier) {
    Text(
      text = label,
      fontSize = 14.sp,
      fontWeight = FontWeight.Medium,
      color = primaryColor,
      modifier = Modifier.padding(bottom = 8.dp)
    )

    Box(
      modifier = Modifier
        .fillMaxWidth()
        .background(backgroundColor, RoundedCornerShape(8.dp))
        .padding(12.dp)
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
      ) {
        Icon(
          painter = painterResource(id = iconRes),
          contentDescription = null,
          tint = Color.Gray,
          modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        BasicTextField(
          value = value,
          onValueChange = onValueChange,
          textStyle = TextStyle(
            fontSize = 15.sp,
            color = Color(0xFF333333)
          ),
          modifier = Modifier.fillMaxWidth(),
          decorationBox = { innerTextField ->
            if (value.text.isEmpty()) {
              Text(
                text = placeholder,
                fontSize = 15.sp,
                color = Color(0xFF999999)
              )
            }
            innerTextField()
          }
        )
      }
    }
  }
}

@Composable
fun FormTextArea(
  value: TextFieldValue,
  onValueChange: (TextFieldValue) -> Unit,
  label: String,
  placeholder: String,
  primaryColor: Color,
  backgroundColor: Color
) {
  Column(modifier = Modifier.fillMaxWidth()) {
    Text(
      text = label,
      fontSize = 14.sp,
      fontWeight = FontWeight.Medium,
      color = primaryColor,
      modifier = Modifier.padding(bottom = 8.dp)
    )

    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .background(backgroundColor, RoundedCornerShape(8.dp))
        .padding(15.dp)
    ) {
      BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
          fontSize = 15.sp,
          color = Color(0xFF333333)
        ),
        modifier = Modifier.fillMaxSize(),
        decorationBox = { innerTextField ->
          if (value.text.isEmpty()) {
            Text(
              text = placeholder,
              fontSize = 15.sp,
              color = Color(0xFF999999)
            )
          }
          innerTextField()
        }
      )
    }
  }
}