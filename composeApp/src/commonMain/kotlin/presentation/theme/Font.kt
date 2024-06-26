package presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import danews.composeapp.generated.resources.Res
import danews.composeapp.generated.resources.cabin_bold
import danews.composeapp.generated.resources.cabin_condensed_bold
import danews.composeapp.generated.resources.cabin_condensed_italic
import danews.composeapp.generated.resources.cabin_condensed_medium
import danews.composeapp.generated.resources.cabin_condensed_regular
import danews.composeapp.generated.resources.cabin_condensed_semibold
import danews.composeapp.generated.resources.cabin_italic
import danews.composeapp.generated.resources.cabin_medium
import danews.composeapp.generated.resources.cabin_regular
import danews.composeapp.generated.resources.cabin_semibold
import danews.composeapp.generated.resources.montserrat_bold
import danews.composeapp.generated.resources.montserrat_light
import danews.composeapp.generated.resources.montserrat_medium
import danews.composeapp.generated.resources.montserrat_regular
import danews.composeapp.generated.resources.montserrat_semibold
import danews.composeapp.generated.resources.poppins_bold
import danews.composeapp.generated.resources.poppins_italic
import danews.composeapp.generated.resources.poppins_light
import danews.composeapp.generated.resources.poppins_medium
import danews.composeapp.generated.resources.poppins_regular
import danews.composeapp.generated.resources.poppins_semibold
import danews.composeapp.generated.resources.poppins_thin
import danews.composeapp.generated.resources.quicksand_bold
import danews.composeapp.generated.resources.quicksand_light
import danews.composeapp.generated.resources.quicksand_medium
import danews.composeapp.generated.resources.quicksand_regular
import danews.composeapp.generated.resources.quicksand_semibold
import danews.composeapp.generated.resources.roboto_black
import danews.composeapp.generated.resources.roboto_bold
import danews.composeapp.generated.resources.roboto_light
import danews.composeapp.generated.resources.roboto_medium
import danews.composeapp.generated.resources.roboto_regular
import org.jetbrains.compose.resources.Font

// We've created this fonts since Google Fonts isn't loaded in the Android Studio Preview and
// we use these fonts 99.9% of the time
@Composable
fun Poppins() = FontFamily(
    Font(Res.font.poppins_thin, FontWeight.Thin),
    Font(Res.font.poppins_light, FontWeight.Light),
    Font(Res.font.poppins_medium, FontWeight.Medium),
    Font(Res.font.poppins_italic, FontWeight.Normal, FontStyle.Italic),
    Font(Res.font.poppins_regular, FontWeight.Normal),
    Font(Res.font.poppins_semibold, FontWeight.SemiBold),
    Font(Res.font.poppins_bold, FontWeight.Bold)
)

@Composable
fun Cabin() = FontFamily(
    Font(Res.font.cabin_regular, FontWeight.Normal),
    Font(Res.font.cabin_medium, FontWeight.Medium),
    Font(Res.font.cabin_italic, FontWeight.Normal, FontStyle.Italic),
    Font(Res.font.cabin_semibold, FontWeight.SemiBold),
    Font(Res.font.cabin_bold, FontWeight.Bold)
)

@Composable
fun CabinSemiCondensed() = FontFamily(
    Font(Res.font.cabin_condensed_regular, FontWeight.Normal),
    Font(Res.font.cabin_condensed_italic, FontWeight.Normal, FontStyle.Italic),
    Font(Res.font.cabin_condensed_medium, FontWeight.Medium),
    Font(Res.font.cabin_condensed_semibold, FontWeight.SemiBold),
    Font(Res.font.cabin_condensed_bold, FontWeight.Bold)
)

@Composable
fun CabinCondensed() = FontFamily(
    Font(Res.font.cabin_condensed_regular, FontWeight.Normal),
    Font(Res.font.cabin_condensed_medium, FontWeight.Medium),
    Font(Res.font.cabin_condensed_semibold, FontWeight.SemiBold),
    Font(Res.font.cabin_condensed_bold, FontWeight.Bold),
    Font(Res.font.cabin_condensed_italic, FontWeight.Normal, FontStyle.Italic),
)



@Composable
fun QuickSand() = FontFamily(
    Font(Res.font.quicksand_light, FontWeight.Light),
    Font(Res.font.quicksand_regular, FontWeight.Normal),
    Font(Res.font.quicksand_medium, FontWeight.Medium),
    Font(Res.font.quicksand_semibold, FontWeight.SemiBold),
    Font(Res.font.quicksand_bold, FontWeight.Bold)
)

@Composable
fun Roboto() = FontFamily(
    Font(Res.font.roboto_light, FontWeight.Light),
    Font(Res.font.roboto_regular, FontWeight.Normal),
    Font(Res.font.roboto_medium, FontWeight.Medium),
    Font(Res.font.roboto_bold, FontWeight.SemiBold),
    Font(Res.font.roboto_black, FontWeight.Bold)
)

@Composable
fun Montserrat() = FontFamily(
    Font(Res.font.montserrat_light, FontWeight.Light),
    Font(Res.font.montserrat_regular, FontWeight.Normal),
    Font(Res.font.montserrat_medium, FontWeight.Medium),
    Font(Res.font.montserrat_semibold, FontWeight.SemiBold),
    Font(Res.font.montserrat_bold, FontWeight.Bold)
)