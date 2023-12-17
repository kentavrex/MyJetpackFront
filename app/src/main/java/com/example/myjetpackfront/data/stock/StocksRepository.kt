package com.example.myjetpackfront.data.stock

import com.example.myjetpackfront.Data
import com.example.myjetpackfront.Stocks
import com.example.myjetpackfront.network.StockService


interface StocksRepository {
    suspend fun getStocks(ticker: String? = null, maxResult: Int): List<Stock>
}


class NetworkStockRepository(
    private val stockService: StockService
): StocksRepository {
    override suspend fun getStocks(
        ticker: String?,
        maxResult: Int
    ): List<Stock> {
        println("Fetching stocks for ticker: $ticker, maxResult: $maxResult")

//        val stocksResponse = stockService.stockSearch(ticker, maxResult)
//        val stocksResponse = stockService.stockSearch()

//        println("Stocks response: $stocksResponse")
//        val stocksResponse = Stocks(
//            arrayListOf(
//                Data("AAPL", 123.45, "https://clck.ru/379ocV"),
//                Data("TSLA", 67.89, "https://clck.ru/379oaQ"),
//                Data("INTC", 67.89, "https://clck.ru/379odp"),
//                Data("MSFT", 67.89, "https://clck.ru/379ocV",),
//                Data("NVDA", 67.89, "https://clck.ru/379ocV")
//            )
//        )
        val stocksResponse: Stocks = if (ticker == null) {
            Stocks(
                arrayListOf(
                    Data("AAPL", 123.45, "https://clck.ru/379ocV"),
                    Data("TSLA", 67.89, "https://clck.ru/379oaQ"),
                    Data("INTC", 67.89, "https://clck.ru/379odp"),
                    Data("MSFT", 67.89, "https://clck.ru/379ocV",),
                    Data("NVDA", 67.89, "https://clck.ru/379ocV")
                )
            )
        } else {
            Stocks(
                arrayListOf(
                    Data("TSLA", 67.89, "https://clck.ru/379oaQ"),
                )
            )
        }
        val stocks = stocksResponse.data.map { data ->
            Stock(
                name = data.name,
                price = data.price,
                imgLink = data.imgLink
            )
        }
        println("Fetched ${stocks.size} stocks")

        return stocks

    }
}