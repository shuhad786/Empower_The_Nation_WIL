package com.example.empowerthenationmobile.composable_icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Menu: ImageVector
    get() {
        if (_Menu != null) return _Menu!!

        _Menu = ImageVector.Builder(
            name = "Menu",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
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

        return _Menu!!
    }

private var _Menu: ImageVector? = null

