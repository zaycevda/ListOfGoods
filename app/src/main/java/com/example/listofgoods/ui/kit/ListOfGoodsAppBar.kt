package com.example.listofgoods.ui.kit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listofgoods.R

@Composable
fun ListOfGoodsAppBar(paddingValues: PaddingValues) {
    val statusBarHeight = paddingValues.calculateTopPadding()

    Text(
        text = stringResource(
            id = R.string.list_of_goods
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .padding(
                top = 16.dp + statusBarHeight,
                bottom = 16.dp
            ),
        style = MaterialTheme.typography.titleLarge.copy(
            textAlign = TextAlign.Center
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun ListOfGoodsAppBarPreview() {
    ListOfGoodsAppBar(paddingValues = PaddingValues.Absolute())
}