package com.example.listofgoods.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.core.text.isDigitsOnly
import com.example.listofgoods.R
import com.example.listofgoods.ui.kit.GoodsItem
import com.example.listofgoods.ui.kit.text_field.SearchTextField
import com.example.listofgoods.ui.kit.spacer.VerticalSpacer
import com.example.listofgoods.ui.model.GoodsModel
import com.example.listofgoods.ui.utils.EMPTY
import com.example.listofgoods.ui.viewmodel.GoodsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun GoodsScreen(
    paddingValues: PaddingValues,
    viewModel: GoodsViewModel = koinViewModel()
) {
    val query = rememberSaveable {
        mutableStateOf(value = EMPTY)
    }
    viewModel.getGoodsList(query = query.value)
    val goodsList by viewModel
        .goodsList
        .collectAsState(initial = listOf())

    val goodsIndex = rememberSaveable {
        mutableStateOf<Int?>(value = null)
    }

    val isChangeAmountDialogVisible = rememberSaveable {
        mutableStateOf(value = false)
    }

    ChangeAmountDialog(
        goodsList = goodsList,
        viewModel = viewModel,
        currentIndex = goodsIndex,
        isVisible = isChangeAmountDialogVisible
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
            .padding(horizontal = 8.dp)
    ) {
        VerticalSpacer(height = 8.dp)
        Search(query = query)
        VerticalSpacer(height = 8.dp)
        GoodsList(
            goodsList = goodsList,
            viewModel = viewModel,
            currentIndex = goodsIndex,
            isAlertDialogVisible = isChangeAmountDialogVisible
        )
    }
}

@Composable
private fun Search(query: MutableState<String>) {
    SearchTextField(
        value = query.value,
        onValueChange = { value ->
            query.value = value
        }
    )
}

@Composable
private fun GoodsList(
    goodsList: List<GoodsModel>,
    viewModel: GoodsViewModel,
    currentIndex: MutableState<Int?>,
    isAlertDialogVisible: MutableState<Boolean>
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(
            space = 4.dp
        )
    ) {
        items(count = goodsList.count()) { index ->
            GoodsItem(
                goodsModel = goodsList[index],
                onDelete = { id ->
                    viewModel.deleteGoods(id = id)
                },
                onEdit = {
                    currentIndex.value = index
                    isAlertDialogVisible.value = true
                }
            )
        }
    }
}

@Composable
private fun ChangeAmountDialog(
    goodsList: List<GoodsModel>,
    viewModel: GoodsViewModel,
    currentIndex: MutableState<Int?>,
    isVisible: MutableState<Boolean>
) {
    if (isVisible.value) {
        val amount = rememberSaveable {
            mutableIntStateOf(value = goodsList[currentIndex.value!!].amount)
        }
        val onEdit = {
            onEdit(
                viewModel = viewModel,
                goodsModel = goodsList[currentIndex.value!!],
                amount = amount.intValue,
                isAlertDialogVisible = isVisible
            )
        }
        val keyboardActions = KeyboardActions(
            onDone = {
                onEdit()
            }
        )

        Dialog(
            onDismissRequest = {
                isVisible.value = false
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                EditAmountTetField(
                    amount = amount,
                    keyboardActions = keyboardActions
                )
                EditAmountButton {
                    onEdit()
                }
            }
        }
    }
}

@Composable
private fun EditAmountTetField(
    amount: MutableIntState,
    keyboardActions: KeyboardActions
) {
    val keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Number,
        imeAction = ImeAction.Done
    )

    TextField(
        value = amount.intValue.toString(),
        onValueChange = { text ->
            if (!text.isDigitsOnly()) {
                return@TextField
            }

            if (text.isEmpty()) {
                amount.intValue = 0
                return@TextField
            }

            text.toIntOrNull()?.let { stringAmount ->
                amount.intValue = stringAmount
            }
        },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}

@Composable
private fun EditAmountButton(onEdit: () -> Unit) {
    Text(
        text = stringResource(
            id = R.string.edit
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onEdit()
            }
    )
}

private fun onEdit(
    viewModel: GoodsViewModel,
    goodsModel: GoodsModel,
    amount: Int,
    isAlertDialogVisible: MutableState<Boolean>
) {
    viewModel.editGoods(
        goods = goodsModel.copy(
            amount = amount
        )
    )
    isAlertDialogVisible.value = false
}

@Preview(showBackground = true)
@Composable
private fun GoodsScreenPreview() {
    GoodsScreen(paddingValues = PaddingValues.Absolute())
}