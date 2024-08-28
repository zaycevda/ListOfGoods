package com.example.listofgoods.ui.kit.spacer

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun HorizontalSpacer(width: Dp) {
    Spacer(
        modifier = Modifier.width(
            width = width
        )
    )
}

@Composable
fun RowScope.HorizontalSpacer() {
    Spacer(
        modifier = Modifier.weight(
            weight = 1F
        )
    )
}