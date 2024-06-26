package di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import presentation.screens.all_news.AllNewsScreenModel
import presentation.screens.article_details.ArticleDetailsScreenModel
import repo.NewsRepo
import repo.NewsRepoImpl
import repo.api.DebugNewsApi
import repo.api.NewsApi

val networkModule = module {

    single<HttpClient> {
        val json = Json { ignoreUnknownKeys = true }
        HttpClient {
            install(ContentNegotiation) {
                json(json)
            }
        }
    }

    single<NewsApi> { DebugNewsApi(Json { ignoreUnknownKeys = true }) }
//    single<NewsApi> { KtorNewsApi(get()) }

    single<NewsRepo> { NewsRepoImpl(get()) }
}

val screenModules = module {
    factoryOf(::AllNewsScreenModel)
    factoryOf(::ArticleDetailsScreenModel)
}


fun initKoin() {
    startKoin {
        modules(
            networkModule,
            screenModules
        )
    }
}