package com.example.listofgoods.ui.kit.text_field

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listofgoods.ui.kit.icon.SearchIcon
import com.example.listofgoods.ui.utils.EMPTY

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange
    ) { innerTextField ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    shape = RoundedCornerShape(
                        size = 8.dp
                    )
                )
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(
                        size = 8.dp
                    )
                )
                .padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchIcon()
            innerTextField()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchTextFieldPreview() {
    var query by remember {
        mutableStateOf(value = EMPTY)
    }

    SearchTextField(
        value = query,
        onValueChange = { value ->
            query = value
        }
    )
}