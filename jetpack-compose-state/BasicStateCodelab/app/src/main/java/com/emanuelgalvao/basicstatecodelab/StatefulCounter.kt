package com.emanuelgalvao.basicstatecodelab

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StatefulCounter(
    modifier: Modifier = Modifier
) {
    var count by remember {
        mutableStateOf(0)
    }
    StatelessCounter(
        count = count,
        onIncrement = {
            count++
        },
        modifier = modifier
    )
}

@Preview
@Composable
fun StatefulCounterPreview() {
    MaterialTheme {
        StatefulCounter()
    }
}