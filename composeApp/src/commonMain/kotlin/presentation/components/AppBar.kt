package presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import presentation.theme.LocalAppColors
import presentation.theme.QuickSand

@Composable
fun AppBar(
    text: String,
    canGoBack: Boolean,
    navigator: Navigator?,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier.fillMaxWidth().height(56.dp),
        elevation = 2.dp
    ) {
        Row(Modifier.fillMaxWidth().padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
            if (canGoBack)
                IconButton(
                    onClick = { navigator?.pop() },
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        modifier = Modifier.size(28.dp),
                        tint = LocalAppColors.current.appThemeTextColor
                    )
                }

            Text(
                text,
                modifier = Modifier.padding(horizontal = if (canGoBack) 2.dp else 12.dp),
                fontSize = 20.sp,
                color = LocalAppColors.current.plainBlackOrWhiteTextColor,
                fontFamily = QuickSand(),
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}