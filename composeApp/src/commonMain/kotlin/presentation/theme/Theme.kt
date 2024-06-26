package presentation.theme

import Black
import Blue
import LightWhite
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LightAppColors = AppColors(
    mainBackground = LightWhite,
    appThemeTextColor = Blue,
    plainBlackOrWhiteTextColor = Black,
    contrastBackground = Color.White
)

val DarkAppColors = AppColors(
    mainBackground = Black,
    appThemeTextColor = Color.White,
    plainBlackOrWhiteTextColor = Color.White,
    contrastBackground = Color.Black
)


val LocalAppColors: ProvidableCompositionLocal<AppColors> = staticCompositionLocalOf<AppColors> { LightAppColors }


class AppColors(
    val mainBackground: Color,
    val appThemeTextColor: Color,
    val plainBlackOrWhiteTextColor: Color,
    val contrastBackground: Color // A deep shade of the background
)