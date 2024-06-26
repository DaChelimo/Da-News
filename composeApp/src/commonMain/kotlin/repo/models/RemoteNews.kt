package repo.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteNews(
    @SerialName("articles")
    val remoteArticles: List<RemoteArticle>?,
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val totalResults: Int?
)