package presentation.screens.all_news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import presentation.components.AppBar
import presentation.components.ArticlePreview
import presentation.components.LoadingScreen
import presentation.screens.article_details.ArticleDetailsScreen

data object AllNewsScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val allNewsScreenModel = getScreenModel<AllNewsScreenModel>()
        val articleList by allNewsScreenModel.news.collectAsState(null)

        Box(Modifier.fillMaxSize()) {
            Column(Modifier.fillMaxSize()) {
                AppBar("Home", false, navigator)

                Spacer(Modifier.height(8.dp))


                if (!articleList.isNullOrEmpty()) {
                    LazyColumn(
                        Modifier.fillMaxSize().padding(horizontal = 12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(articleList!!) { article ->
                            ArticlePreview(
                                article = article,
                                openArticle = {
                                    navigator?.push(ArticleDetailsScreen(article))
                                }
                            )
                        }
                    }
                }
            }

            if (articleList.isNullOrEmpty())
                LoadingScreen()
        }
    }
}