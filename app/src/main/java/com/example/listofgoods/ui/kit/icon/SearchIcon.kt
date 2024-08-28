package com.example.listofgoods.ui.kit.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchIcon() {
    Icon(
        imageVector = Icons.Default.Search,
        contentDescription = "search"
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchIconPreview() {
    SearchIcon()
}