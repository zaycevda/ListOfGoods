package com.example.listofgoods.ui.kit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listofgoods.R
import com.example.listofgoods.ui.utils.formattedDate
import com.example.listofgoods.ui.kit.icon.DeleteIcon
import com.example.listofgoods.ui.kit.icon.EditIcon
import com.example.listofgoods.ui.kit.spacer.HorizontalSpacer
import com.example.listofgoods.ui.kit.spacer.VerticalSpacer
import com.example.listofgoods.ui.kit.text.Title
import com.example.listofgoods.ui.model.GoodsModel

@Composable
fun GoodsItem(
    goodsModel: GoodsModel,
    onDelete: (Int) -> Unit,
    onEdit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 1.dp)
            .padding(all = 8.dp)
    ) {
        Top(
            title = goodsModel.name,
            onDelete = {
                onDelete(goodsModel.id)
            },
            onEdit = onEdit
        )
        VerticalSpacer(height = 8.dp)
        Tags(tags = goodsModel.tags)
        VerticalSpacer(height = 8.dp)
        LabeledValues(
            amount = goodsModel.amount.toString(),
            date = goodsModel.time.formattedDate
        )
    }
}

@Composable
private fun Top(
    title: String,
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {
    Row {
        Title(text = title)
        HorizontalSpacer()
        EditIcon(onEdit = onEdit)
        HorizontalSpacer(width = 8.dp)
        DeleteIcon(onDelete = onDelete)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Tags(tags: List<String>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(
            space = 8.dp
        ),
        verticalArrangement = Arrangement.spacedBy(
            space = 4.dp
        )
    ) {
        tags.forEach { tag ->
            Tag(text = tag)
        }
    }
}

@Composable
private fun LabeledValues(
    amount: String,
    date: String
) {
    Row {
        InStock(text = amount)
        HorizontalSpacer()
        DateAdded(text = date)
        HorizontalSpacer(width = 24.dp)
    }
}

@Composable
private fun InStock(text: String) {
    LabeledValue(
        label = stringResource(
            id = R.string.in_stock
        ),
        value = text
    )
}

@Composable
private fun DateAdded(text: String) {
    LabeledValue(
        label = stringResource(
            id = R.string.date_added
        ),
        value = text
    )
}

@Preview(showBackground = true)
@Composable
private fun GoodsItemPreview() {
    val goodsModel = GoodsModel(
        id = 1,
        name = "iPhone 13",
        time = 1633046400000,
        tags = listOf(
            "Телефон",
            "Новый",
            "Распродажа"
        ),
        amount = 15
    )

    GoodsItem(
        goodsModel = goodsModel,
        onDelete = {},
        onEdit = {}
    )
}