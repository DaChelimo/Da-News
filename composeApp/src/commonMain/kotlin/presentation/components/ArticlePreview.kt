package presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import danews.composeapp.generated.resources.Res
import danews.composeapp.generated.resources.error_news
import domain.news.Article
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.painterResource
import presentation.theme.Cabin
import presentation.theme.LocalAppColors
import presentation.theme.Poppins
import utils.formatTimeToPublishedDate

@Composable
fun ArticlePreview(article: Article, modifier: Modifier = Modifier, openArticle: (String) -> Unit) {
    Card(modifier.fillMaxWidth().clickable { openArticle(article.articleUrl) }) {
        Column(Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
            NewsImage(
                modifier = Modifier.fillMaxWidth(),
                imageUrl = article.imageUrl,
                imageHeight = 200.dp,
                loadingSpinnerSize = 52.dp
            )

            Text(
                text = article.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
                fontFamily = Poppins(),
                color = LocalAppColors.current.plainBlackOrWhiteTextColor
            )

            Text(
                text = article.description,
                fontSize = 14.sp,
                lineHeight = (16.5).sp,
                fontWeight = FontWeight.Light,
                fontFamily = Poppins(),
                modifier = Modifier.padding(top = 2.dp),
                color = LocalAppColors.current.plainBlackOrWhiteTextColor.copy(alpha = 0.85f)
            )

            Text(
                text = article.publishedAt.formatTimeToPublishedDate(),
                fontFamily = Cabin(),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 4.dp, bottom = 8.dp),
                color = LocalAppColors.current.plainBlackOrWhiteTextColor.copy(alpha = 0.75f)
            )
        }
    }
}


@Composable
fun NewsImage(modifier: Modifier = Modifier, imageUrl: String, imageHeight: Dp, loadingSpinnerSize: Dp) {
    KamelImage(
        resource = asyncPainterResource(imageUrl),
        contentDescription = null,
        onLoading = {
            Box(Modifier.height(imageHeight)) {
                CircularProgressIndicator(
                    Modifier.size(loadingSpinnerSize).align(Alignment.Center),
                    color = LocalAppColors.current.appThemeTextColor
                )
            }
        },
        onFailure = {
            Box(Modifier.height(imageHeight)) {
                Image(
                    painter = painterResource(Res.drawable.error_news),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        },
        contentScale = ContentScale.Crop,
        modifier = modifier
            .height(imageHeight)
            .fillMaxSize()
            .clip(RoundedCornerShape(6.dp))
    )
}