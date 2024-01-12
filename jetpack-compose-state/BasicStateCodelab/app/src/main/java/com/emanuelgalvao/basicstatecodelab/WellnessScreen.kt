package com.emanuelgalvao.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    wellnessViewModel: WellnessViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        StatefulCounter()
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCloseTask = {
                wellnessViewModel.remove(it)
            },
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            }
        )
    }

}

@Preview
@Composable
fun WellnessScreenPreview() {
    MaterialTheme {
        WellnessScreen()
    }
}