package presentation.screens.all_news

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.asFlow
import repo.NewsRepo

class AllNewsScreenModel(
    private val newsRepo: NewsRepo
): ScreenModel {

    val news = newsRepo.getNews()

}