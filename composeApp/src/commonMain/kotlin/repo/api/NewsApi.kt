package repo.api

import com.da_chelimo.news.BuildKonfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.lighthousegames.logging.logging
import repo.models.RemoteNews

interface NewsApi {

    suspend fun getNews(): RemoteNews

}

expect class JsonLoader() {
    fun loadJsonFile(fileName: String = "files/news.json"): String?
}

//
class DebugNewsApi (
    private val json: Json
): NewsApi {

    @OptIn(ExperimentalResourceApi::class)
    override suspend fun getNews(): RemoteNews {
        val newsInJson = JsonLoader().loadJsonFile()!!
        return json.decodeFromString<RemoteNews>(newsInJson)
    }
}


class KtorNewsApi(
    private val client: HttpClient
): NewsApi {
    companion object {
        val log = logging()
        const val BASE_URL = "https://newsapi.org/v2/"
    }

    override suspend fun getNews(): RemoteNews {
        val techCrunch = "${BASE_URL}top-headlines?sources=techcrunch&apiKey=${BuildKonfig.NEWS_API_KEY}"
        log.d { "techCrunch is $techCrunch" }

        val response = client.get(techCrunch)
        log.d { "response.status is ${response.status}" }

        return response.body()
    }
}