package com.example.myjetpackfront.data

import com.example.myjetpackfront.data.book.BooksRepository
import com.example.myjetpackfront.data.book.NetworkBookRepository
import com.example.myjetpackfront.data.stock.NetworkStockRepository
import com.example.myjetpackfront.data.stock.StocksRepository
import com.example.myjetpackfront.network.BookService
import com.example.myjetpackfront.network.StockService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val booksRepository: BooksRepository
    val stocksRepository: StocksRepository
}

class DefaultContainer: AppContainer {
    private val GOOGLE_BOOKS_URL = "https://www.googleapis.com/books/v1/"
    private val STOCKS_URL = "http://localhost:8080/"

    private val googleBooksRetrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(GOOGLE_BOOKS_URL)
        .build()

    private val googleBooksRetrofitService: BookService by lazy {
        googleBooksRetrofit.create(BookService::class.java)
    }

    override val booksRepository: BooksRepository by lazy {
        NetworkBookRepository(googleBooksRetrofitService)  // Dependency injection manual
    }


    private val stocksRetrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(STOCKS_URL)
        .build()

    private val stocksRetrofitService: StockService by lazy {
        stocksRetrofit.create(StockService::class.java)
    }

    override val stocksRepository: StocksRepository by lazy {
        NetworkStockRepository(stocksRetrofitService)  // Dependency injection manual
    }
}