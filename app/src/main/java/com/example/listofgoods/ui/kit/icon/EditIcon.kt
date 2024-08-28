package com.example.listofgoods.ui.kit.icon

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EditIcon(onEdit: () -> Unit) {
    Icon(
        imageVector = Icons.Default.Edit,
        contentDescription = "edit",
        modifier = Modifier.clickable {
            onEdit()
        },
        tint = Color.Magenta
    )
}

@Preview(showBackground = true)
@Composable
private fun EditIconPreview() {
    EditIcon {}
}