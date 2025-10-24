package com.example.empowerthenationmobile.ui.contact

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.empowerthenationmobile.R
import androidx.core.net.toUri

@Composable
fun ContactScreen() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F0E0))
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_logo),
            contentDescription = "Watermark Logo",
            modifier = Modifier
                .size(550.dp)
                .align(Alignment.Center)
                .offset(y = 50.dp),
            contentScale = ContentScale.Fit,
            alpha = 0.15f
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "We're here to help you on your journey. Reach out to us through any of our channels or visit one of our Johannesburg locations. Our dedicated team is ready to assist you with any questions or information you may need.",
                fontSize = 15.sp,
                color = Color(0xFFCB7318),
                textAlign = TextAlign.Center,
                lineHeight = 22.sp,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            ) {
                Column(
                    modifier = Modifier.padding(0.dp)
                ) {
                    Text(
                        text = "Contact Information",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFCB7318),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    ContactInfoItem(
                        icon = R.drawable.chat_icon,
                        text = "Get In Touch"
                    )
                    ContactInfoItem(
                        icon = R.drawable.clock_icon,
                        text = "Operating Hours"
                    )
                    ContactInfoItem(
                        icon = R.drawable.email_icon,
                        text = "info@empoweringthenation.org.za",
                        onClickUrl = "mailto:info@empoweringthenation.org.za",
                        context = context
                    )
                    ContactInfoItem(
                        icon = R.drawable.call_icon,
                        text = "+27 11 123 4567",
                        onClickUrl = "tel:+27111234567",
                        context = context
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Image(
                        painter = painterResource(id = R.drawable.headquarters_map),
                        contentDescription = "Head Office Location",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clickable {
                                openUrl(
                                    context,
                                    "https://www.google.com/maps/place/123+Empowerment+Street,+Johannesburg+Central"
                                )
                            },
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Head Office",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFCB7318),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    ContactInfoItem(
                        icon = R.drawable.location_icon,
                        text = "123 Empowerment Street\nJohannesburg Central\n2000 South Africa"
                    )
                    ContactInfoItem(
                        icon = R.drawable.train_icon,
                        text = "Gautrain: Johannesburg Station\nRea Vaya: BRT Line 1A"
                    )
                    ContactInfoItem(
                        icon = R.drawable.car_icon,
                        text = "Security: Underground parking available\nAccess from Empowerment Street"
                    )
                    ContactInfoItem(
                        icon = R.drawable.info_icon,
                        text = "Wheelchair accessible\nConference facilities available\nFree Wi-Fi throughout the building"
                    )
                }
            }

            VenueCard(
                title = "Sandton\nEmpowerment Centre",
                subtitle = "Financial District Hub",
                location = "Nelson Mandela Square, Sandton, 2196",
                phone = "+27 11 234 5678",
                email = "sandton@empowering.org.za",
                hours = "Mon-Fri: 8:30 AM - 6:00 PM",
                mapImage = R.drawable.sandton_map,
                mapsUrl = "https://maps.app.goo.gl/XNy7y9i9PU94i1zt9",
                context = context
            )

            Spacer(modifier = Modifier.height(16.dp))

            VenueCard(
                title = "Soweto Community\nHub",
                subtitle = "Grassroots Development Center",
                location = "Walter Sisulu Square, Kliptown, Soweto, 1801",
                phone = "+27 11 345 6789",
                email = "soweto@empowering.org.za",
                hours = "Mon-Sat: 8:00 AM - 5:00 PM",
                mapImage = R.drawable.soweto_map,
                mapsUrl = "https://maps.app.goo.gl/p6tBCB5T7tg1JHcb7",
                context = context
            )

            Spacer(modifier = Modifier.height(16.dp))

            VenueCard(
                title = "Midrand Innovation\nCentre",
                subtitle = "Technology & Learning Space",
                location = "Gallagher Convention Centre, Midrand, 1685",
                phone = "+27 11 456 7890",
                email = "midrand@empowering.org.za",
                hours = "Mon-Fri: 9:00 AM - 7:00 PM",
                mapImage = R.drawable.midrand_map,
                mapsUrl = "https://maps.app.goo.gl/nobuxYbXr2XgD62m8",
                context = context
            )
        }
    }
}

@Composable
fun ContactInfoItem(
    icon: Int,
    text: String,
    onClickUrl: String? = null,
    context: android.content.Context? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clickable(enabled = onClickUrl != null) {
                if (onClickUrl != null && context != null) {
                    openUrl(context, onClickUrl)
                }
            },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .padding(top = 2.dp),
            contentScale = ContentScale.Fit,
            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.Black)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color(0xFF333333),
            lineHeight = 20.sp
        )
    }
}

@Composable
fun VenueCard(
    title: String,
    subtitle: String,
    location: String,
    phone: String,
    email: String,
    hours: String,
    mapImage: Int,
    mapsUrl: String,
    context: android.content.Context
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF2E652E))
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = title,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        lineHeight = 22.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = subtitle,
                        fontSize = 13.sp,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }

            // Body
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                VenueInfoItem(
                    icon = R.drawable.location_icon,
                    text = location
                )
                VenueInfoItem(
                    icon = R.drawable.call_icon,
                    text = phone,
                    onClickUrl = "tel:${phone.replace(" ", "").replace("-", "")}",
                    context = context
                )
                VenueInfoItem(
                    icon = R.drawable.email_icon,
                    text = email,
                    onClickUrl = "mailto:$email",
                    context = context
                )
                VenueInfoItem(
                    icon = R.drawable.clock_icon,
                    text = hours
                )
            }

            // Map
            Image(
                painter = painterResource(id = mapImage),
                contentDescription = "Location Map",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clickable {
                        openUrl(context, mapsUrl)
                    },
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun VenueInfoItem(
    icon: Int,
    text: String,
    onClickUrl: String? = null,
    context: android.content.Context? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
            .clickable(enabled = onClickUrl != null) {
                if (onClickUrl != null && context != null) {
                    openUrl(context, onClickUrl)
                }
            },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(18.dp)
                .padding(top = 2.dp),
            contentScale = ContentScale.Fit,
            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color(0xFFCB7318))
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color(0xFF555555),
            lineHeight = 20.sp
        )
    }
}

private fun openUrl(context: android.content.Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
    context.startActivity(intent)
}