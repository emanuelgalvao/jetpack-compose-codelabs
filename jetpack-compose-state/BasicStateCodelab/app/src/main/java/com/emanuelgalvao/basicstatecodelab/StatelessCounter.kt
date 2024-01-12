package com.emanuelgalvao.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(
            onClick = {
                onIncrement()
            },
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text("Add one")
        }
    }
}

@Preview
@Composable
fun StatelessCounterPreview() {
    MaterialTheme {
        StatelessCounter(
            count = 0,
            onIncrement = {}
        )
    }
}