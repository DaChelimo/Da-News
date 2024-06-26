package repo.models


import domain.news.Article
import domain.news.Source
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteArticle(
    @SerialName("author")
    val author: String,
    @SerialName("content")
    val content: String,
    @SerialName("description")
    val description: String,
    @SerialName("publishedAt")
    val publishedAt: String,
    @SerialName("source")
    val remoteSource: RemoteSource,
    @SerialName("title")
    val title: String,
    @SerialName("url")
    val url: String,
    @SerialName("urlToImage")
    val urlToImage: String
) {

    fun toArticle() =
        Article(
            author = author,
            content = content,
            description = description,
            publishedAt = publishedAt,
            source = Source(remoteSource.id, remoteSource.name),
            title = title,
            articleUrl = url,
            imageUrl = urlToImage
        )

}