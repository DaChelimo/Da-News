package repo

import domain.news.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepo {

    fun getNews(): Flow<List<Article>>

}