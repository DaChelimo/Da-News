import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.lighthousegames.logging.KmLogging
import org.lighthousegames.logging.LogLevel
import presentation.screens.all_news.AllNewsScreen
import presentation.theme.DarkAppColors
import presentation.theme.LightAppColors
import presentation.theme.LocalAppColors

@Composable
@Preview
fun App(isDarkMode: Boolean = false) {
    LaunchedEffect(Unit) {
        KmLogging.setLogLevel(LogLevel.Debug)
    }

    MaterialTheme {
        Scaffold(Modifier.fillMaxSize()) {
            val appColors = remember {
                if (isDarkMode) DarkAppColors else LightAppColors
            }
            CompositionLocalProvider(LocalAppColors provides appColors) {

                Column(Modifier.background(LocalAppColors.current.mainBackground)) {
                    Navigator(AllNewsScreen)
                }
            }
        }
    }
//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
//    }
}