package com.example.empowerthenationmobile.ui.forms

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.*
import com.example.empowerthenationmobile.R

data class Course(
    val name: String,
    val fee: Double,
    val duration: String
)

@Composable
fun CalculatorScreen() {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val courses = remember {
        listOf(
            Course("First Aid", 1500.0, "6 months"),
            Course("Sewing", 1500.0, "6 months"),
            Course("Landscaping", 1500.0, "6 months"),
            Course("Life Skills", 1500.0, "6 months"),
            Course("Child Minding", 750.0, "6 weeks"),
            Course("Cooking", 750.0, "6 weeks"),
            Course("Garden Maintenance", 750.0, "6 weeks")
        )
    }

    val selectedCourses = remember { mutableStateListOf<Course>() }
    var showResult by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFF5F7FA),
                        Color(0xFFC3CFE2)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            // Main Container
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                shape = RoundedCornerShape(12.dp),
                shadowElevation = 10.dp,
                color = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(24.dp)
                ) {
                    // Title
                    Text(
                        text = "COURSE REGISTRATION & FEE CALCULATOR",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 32.dp),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        letterSpacing = 1.sp
                    )

                    // Personal Details Section
                    SectionTitle("Personal Details")

                    Spacer(modifier = Modifier.height(16.dp))

                    InputField(
                        value = name,
                        onValueChange = { name = it },
                        label = "Full Name",
                        placeholder = "Enter Your Full Name",
                        icon = R.drawable.user_circle
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        InputField(
                            value = phone,
                            onValueChange = { phone = it },
                            label = "Phone Number",
                            placeholder = "Enter Your Phone Number",
                            icon = R.drawable.phone,
                            modifier = Modifier.weight(1f)
                        )

                        InputField(
                            value = email,
                            onValueChange = { email = it },
                            label = "Email Address",
                            placeholder = "Enter Your Email",
                            icon = R.drawable.envelope,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    // Courses Section
                    SectionTitle("Select Course(s)")

                    Spacer(modifier = Modifier.height(16.dp))

                    // Courses Grid
                    courses.chunked(2).forEach { rowCourses ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            rowCourses.forEach { course ->
                                CourseCard(
                                    course = course,
                                    isSelected = selectedCourses.contains(course),
                                    onSelectionChange = { isSelected ->
                                        if (isSelected) {
                                            selectedCourses.add(course)
                                        } else {
                                            selectedCourses.remove(course)
                                        }
                                        showResult = false
                                        errorMessage = ""
                                    },
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            // Add empty space if odd number of courses in row
                            if (rowCourses.size == 1) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Calculate Button
                    Button(
                        onClick = {
                            when {
                                name.isBlank() || phone.isBlank() || email.isBlank() -> {
                                    errorMessage = "Please fill in all personal details."
                                    showResult = false
                                }
                                selectedCourses.isEmpty() -> {
                                    errorMessage = "Please select at least one course."
                                    showResult = false
                                }
                                else -> {
                                    errorMessage = ""
                                    showResult = true
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFCB7318)
                        ),
                        shape = RoundedCornerShape(8.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 4.dp,
                            pressedElevation = 2.dp
                        )
                    ) {
                        Text(
                            text = "Calculate Total Fees",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    // Error Message
                    if (errorMessage.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(24.dp))
                        Surface(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFFFEBEE)
                        ) {
                            Text(
                                text = errorMessage,
                                color = Color(0xFFD32F2F),
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(20.dp)
                            )
                        }
                    }

                    // Result Section
                    if (showResult && selectedCourses.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(32.dp))

                        ResultSection(
                            name = name,
                            phone = phone,
                            email = email,
                            selectedCourses = selectedCourses
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFCB7318)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    icon: Int, // 👈 change from ImageVector to Int
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color(0xFFCB7318),
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder, color = Color(0xFF999999)) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = label,
                    tint = Color(0xFFCB7318)
                )
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0x14000000),
                unfocusedContainerColor = Color(0x0F000000),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            singleLine = true
        )
    }
}


@Composable
fun CourseCard(
    course: Course,
    isSelected: Boolean,
    onSelectionChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clickable { onSelectionChange(!isSelected) }
            .height(120.dp),
        shape = RoundedCornerShape(10.dp),
        border = androidx.compose.foundation.BorderStroke(
            width = 2.dp,
            color = if (isSelected) Color(0xFFCB7318) else Color(0xFFE0E0E0)
        ),
        color = if (isSelected) Color(0x0DCB7318) else Color.White,
        shadowElevation = if (isSelected) 8.dp else 0.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Checkbox(
                checked = isSelected,
                onCheckedChange = onSelectionChange,
                modifier = Modifier.align(Alignment.TopEnd),
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFCB7318),
                    checkmarkColor = Color.White
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 32.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = course.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF333333)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = formatCurrency(course.fee),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFCB7318)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = course.duration,
                    fontSize = 13.sp,
                    color = Color(0xFF666666),
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}

@Composable
fun ResultSection(
    name: String,
    phone: String,
    email: String,
    selectedCourses: List<Course>
) {
    val subtotal = selectedCourses.sumOf { it.fee }
    val discountRate = getDiscountRate(selectedCourses.size)
    val discountAmount = subtotal * discountRate
    val discountedTotal = subtotal - discountAmount
    val vat = discountedTotal * 0.15
    val total = discountedTotal + vat

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFFF8F9FA),
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            // Customer Details
            Text(
                text = "Customer Details:",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFFCB7318)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                DetailRow("Name:", name)
                DetailRow("Phone:", phone)
                DetailRow("Email:", email)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Selected Courses
            Text(
                text = "Selected Courses:",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFFCB7318)
            )

            Spacer(modifier = Modifier.height(12.dp))

            selectedCourses.forEach { course ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    shape = RoundedCornerShape(6.dp),
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${course.name} (${course.duration})",
                            fontSize = 14.sp,
                            color = Color(0xFF333333),
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = formatCurrency(course.fee),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF333333)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Divider(
                thickness = 2.dp,
                color = Color(0xFFCB7318)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Financial Summary
            FinancialRow("Subtotal:", formatCurrency(subtotal))

            if (discountRate > 0) {
                FinancialRow(
                    "Discount (${(discountRate * 100).toInt()}%):",
                    "-${formatCurrency(discountAmount)}",
                    color = Color(0xFF2E7D32)
                )
                FinancialRow("Discounted Subtotal:", formatCurrency(discountedTotal))
            }

            FinancialRow("VAT (15%):", formatCurrency(vat))

            Spacer(modifier = Modifier.height(16.dp))

            // Total
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                color = Color.White,
                border = androidx.compose.foundation.BorderStroke(2.dp, Color(0xFFCB7318))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total Quoted Fee:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = formatCurrency(total),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFCB7318)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Divider(thickness = 1.dp, color = Color(0xFFDDDDDD))

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "This is a quoted fee and not a formal invoice. A consultant will contact you to finalize your course booking.",
                fontSize = 12.sp,
                color = Color(0xFF666666),
                fontStyle = FontStyle.Italic,
                lineHeight = 16.sp
            )
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Row(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color(0xFF333333)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = value,
            fontSize = 14.sp,
            color = Color(0xFF333333)
        )
    }
}

@Composable
fun FinancialRow(label: String, value: String, color: Color = Color(0xFF333333)) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = color
        )
        Text(
            text = value,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = color
        )
    }
}

fun getDiscountRate(courseCount: Int): Double {
    return when {
        courseCount >= 3 -> 0.15
        courseCount == 2 -> 0.05
        else -> 0.0
    }
}

fun formatCurrency(amount: Double): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("en", "ZA"))
    return formatter.format(amount).replace("ZAR", "R")
}