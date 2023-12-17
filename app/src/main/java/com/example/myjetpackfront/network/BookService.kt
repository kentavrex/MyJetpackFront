package com.example.myjetpackfront.network

import com.example.myjetpackfront.network.model.book.BookShelf
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    @GET("volumes")
    suspend fun bookSearch(
        @Query("q") searchQuery: String,
        @Query("max_results") maxResult: Int
    ): BookShelf
}