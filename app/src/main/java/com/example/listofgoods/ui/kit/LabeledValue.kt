package com.example.listofgoods.ui.kit

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listofgoods.ui.kit.spacer.VerticalSpacer

@Composable
fun LabeledValue(
    label: String,
    value: String
) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.titleSmall
        )
        VerticalSpacer(height = 4.dp)
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LabeledValuePreview() {
    LabeledValue(
        label = "На складе",
        value = 15.toString()
    )
}