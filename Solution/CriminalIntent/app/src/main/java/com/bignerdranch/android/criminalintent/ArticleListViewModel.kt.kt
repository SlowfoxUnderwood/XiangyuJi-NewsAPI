package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import java.util.Date
import java.util.UUID

class ArticleListViewModel : ViewModel() {
    private val _selectedCategory = MutableLiveData<String>()
    val selectedCategory: LiveData<String> = _selectedCategory

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    fun setCategory(category: String) {
        if (category != _selectedCategory.value) {
            _selectedCategory.value = category
            fetchArticlesByCategory(category)
        }
    }

    private fun fetchArticlesByCategory(category: String) {
        viewModelScope.launch {
            val response = RetrofitInstance.api.getTopHeadlines(category = category, apiKey = "YOUR_API_KEY")
            if (response.isSuccessful) {
                _articles.postValue(response.body()?.articles)
            } else {
                // Handle error
            }
        }
    }
}


    val crimes = mutableListOf<Crime>()

    init {
        for (i in 0 until 100) {
            val crime = Crime(
                id = UUID.randomUUID(),
                title ="Crime #$i",
                date = Date(),
                isSolved = i % 2 == 0
            )

            crimes += crime
        }
    }
}
