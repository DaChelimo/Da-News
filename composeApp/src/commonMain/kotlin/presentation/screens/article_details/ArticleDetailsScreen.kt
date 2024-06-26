package presentation.screens.article_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import domain.news.Article
import presentation.components.AppBar
import presentation.components.NewsImage
import presentation.theme.Cabin
import presentation.theme.LocalAppColors
import presentation.theme.Poppins
import utils.formatTimeToPublishedDate

data class ArticleDetailsScreen(val article: Article) : Screen {

    @Composable
    override fun Content() {

        AppBar(article.source.name, true, LocalNavigator.current)

        Column(Modifier.padding(horizontal = 12.dp).fillMaxSize()) {
            NewsImage(
                modifier = Modifier.padding(top = 12.dp),
                imageUrl = article.imageUrl,
                imageHeight = 250.dp,
                loadingSpinnerSize = 60.dp
            )

            Text(
                text = article.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                fontFamily = Poppins(),
                color = LocalAppColors.current.plainBlackOrWhiteTextColor
            )

            Text(
                text = article.publishedAt.formatTimeToPublishedDate(),
                fontFamily = Cabin(),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 4.dp),
                color = LocalAppColors.current.plainBlackOrWhiteTextColor.copy(alpha = 0.75f)
            )

            Text(
                text = article.content,
                fontSize = 15.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Light,
                fontFamily = Poppins(),
                modifier = Modifier.padding(top = 8.dp),
                color = LocalAppColors.current.plainBlackOrWhiteTextColor.copy(alpha = 0.85f)
            )
        }
    }
}