package com.example.empowerthenationmobile.composable_icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.example.empowerthenationmobile.ui.theme.OrangeText


val Menu: ImageVector
    get() {
        if (_Menu != null) return _Menu!!

        _Menu = ImageVector.Builder(
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

        return _Menu!!
    }

private var _Menu: ImageVector? = null

