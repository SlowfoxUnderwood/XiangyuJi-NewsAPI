import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface `NewsApiService.kt` {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsApiResponse> // Define NewsApiResponse based on the JSON structure provided by your API
}
