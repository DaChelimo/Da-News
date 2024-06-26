package domain.news

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val articleUrl: String,
    val imageUrl: String
)