package com.emanuelgalvao.jetpack_compose_basics

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.emanuelgalvao.jetpack_compose_basics.ui.theme.JetpackcomposebasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposebasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
private fun MyApp(
    modifier: Modifier = Modifier
) {
    var shouldShowOnboarding by rememberSaveable {
        mutableStateOf(true)
    }

    Surface(
        modifier = modifier
    ) {
        if (shouldShowOnboarding) {
            OnboardingScreen(
                onContinueClicked = {
                    shouldShowOnboarding = false
                }
            )
        } else {
            Greetings()
        }
    }

}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun MyAppPreview() {
    JetpackcomposebasicsTheme {
        MyApp(Modifier.fillMaxSize())
    }
}

@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "$it" }
) {
    LazyColumn(
        modifier = modifier.padding(vertical = 4.dp)
    ) {
        items(names) { name ->
            Greeting(name)
        }
    }
}

@Preview
@Composable
fun GreetingsPreview() {
    JetpackcomposebasicsTheme {
        Greetings()
    }
}

@Composable
fun Greeting(name: String) {

    var expanded by remember { mutableStateOf(false) }

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            )
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text("Hello,")
                Text(
                    text = name,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                if (expanded) {
                    Text(
                        text = ("Composem ipsum color sit lazy, " +
                                "padding theme elit, sed do bouncy. ").repeat(4),
                    )
                }
            }
            IconButton(
                onClick = {
                    expanded = !expanded
                }
            ) {
                val icon = if (expanded) {
                    Icons.Rounded.ExpandLess
                } else {
                    Icons.Rounded.ExpandMore
                }
                Icon(
                    imageVector = icon,
                    contentDescription = null
                )
            }
        }

    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Preview
@Composable
fun GreetingPreview() {
    JetpackcomposebasicsTheme {
        Greeting(name = "Android")
    }
}

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onContinueClicked: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to Basics Codelab!")
        Button(
            onClick = {
                onContinueClicked()
            },
            modifier = Modifier
                .padding(vertical = 24.dp)
        ) {
            Text(text = "Continue")
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    JetpackcomposebasicsTheme {
        OnboardingScreen(
            onContinueClicked = {}
        )
    }
}