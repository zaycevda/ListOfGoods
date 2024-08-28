package com.example.listofgoods.ui.kit.icon

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DeleteIcon(onDelete: () -> Unit) {
    Icon(
        imageVector = Icons.Default.Delete,
        contentDescription = "delete",
        modifier = Modifier.clickable {
            onDelete()
        },
        tint = Color.Red
    )
}

@Preview(showBackground = true)
@Composable
private fun DeleteIconPreview() {
    DeleteIcon {}
}