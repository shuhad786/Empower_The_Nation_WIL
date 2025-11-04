package com.example.empowerthenationmobile.composable_icons

import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.example.empowerthenationmobile.ui.theme.OrangeText


val Menu: ImageVector
    get() {
        if (AMenu != null) return AMenu!!

        AMenu = ImageVector.Builder(
            name = "Menu",
            defaultWidth = 30.dp,
            defaultHeight = 30.dp,
            viewportWidth = 30f,
            viewportHeight = 30f
        ).apply {
            path(
                fill = SolidColor(OrangeText)
            ) {
                // Top bar
                moveTo(3f, 6f)
                horizontalLineToRelative(18f)
                verticalLineToRelative(2f)
                horizontalLineToRelative(-18f)
                close()

                // Middle bar
                moveTo(3f, 11f)
                horizontalLineToRelative(18f)
                verticalLineToRelative(2f)
                horizontalLineToRelative(-18f)
                close()

                // Bottom bar
                moveTo(3f, 16f)
                horizontalLineToRelative(18f)
                verticalLineToRelative(2f)
                horizontalLineToRelative(-18f)
                close()
            }
        }.build()

        return AMenu!!
    }

private var AMenu: ImageVector? = null

