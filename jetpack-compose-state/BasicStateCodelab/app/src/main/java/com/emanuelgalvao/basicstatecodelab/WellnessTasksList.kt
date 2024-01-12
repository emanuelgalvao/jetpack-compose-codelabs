package com.emanuelgalvao.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { item ->
            WellnessTaskItem(
                taskName = item.label,
                checked = item.checked,
                onClose = {
                    onCloseTask(item)
                },
                onCheck = {
                    onCheckedTask(item, it)
                }
            )
        }
    }
}