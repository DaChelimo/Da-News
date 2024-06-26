package repo

import domain.news.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.withContext
import org.lighthousegames.logging.logging
import repo.api.NewsApi


class NewsRepoImpl(
    private val newsApi: NewsApi
): NewsRepo {

    override fun getNews() = callbackFlow {
        val remoteNews = newsApi.getNews()
        val articles = remoteNews.remoteArticles?.map { it.toArticle() } ?: listOf()
        log.d { "Articles is $articles" }

        trySend(articles)

        awaitClose { }
    }.catch {
        it.printStackTrace()
    }


    companion object {
        val log = logging()
    }
}