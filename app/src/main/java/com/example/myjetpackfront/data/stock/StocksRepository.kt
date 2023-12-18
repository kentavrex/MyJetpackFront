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
                    Data("AAPL", 123.45, "https://en.wikipedia.org/wiki/Apple_Inc."),
                    Data("TSLA", 67.89, "https://en.wikipedia.org/wiki/Tesla,_Inc."),
                    Data("INTC", 45.67, "https://en.wikipedia.org/wiki/Intel"),
                    Data("MSFT", 89.12, "https://en.wikipedia.org/wiki/Microsoft"),
                    Data("GOOGL", 34.56, "https://en.wikipedia.org/wiki/Alphabet_Inc."),
                    Data("AMZN", 78.90, "https://en.wikipedia.org/wiki/Amazon_(company)"),
                    Data("FB", 56.78, "https://en.wikipedia.org/wiki/Meta_Platforms"),
                    Data("NFLX", 90.12, "https://en.wikipedia.org/wiki/Netflix"),
                    Data("GOOG", 45.67, "https://en.wikipedia.org/wiki/Google"),
                    Data("IBM", 78.90, "https://en.wikipedia.org/wiki/IBM"),
                    Data("GS", 123.45, "https://en.wikipedia.org/wiki/Goldman_Sachs"),
                    Data("BA", 67.89, "https://en.wikipedia.org/wiki/Boeing"),
                    Data("CSCO", 34.56, "https://en.wikipedia.org/wiki/Cisco_Systems"),
                    Data("DIS", 56.78, "https://en.wikipedia.org/wiki/The_Walt_Disney_Company"),
                    Data("JPM", 78.90, "https://en.wikipedia.org/wiki/JPMorgan_Chase"),
                    Data("PG", 90.12, "https://en.wikipedia.org/wiki/Procter_%26_Gamble"),
                    Data("CAT", 45.67, "https://en.wikipedia.org/wiki/Caterpillar_Inc."),
                    Data("KO", 78.90, "https://en.wikipedia.org/wiki/The_Coca-Cola_Company"),
                    Data("MMM", 34.56, "https://en.wikipedia.org/wiki/3M"),
                    Data("VZ", 56.78, "https://en.wikipedia.org/wiki/Verizon_Communications")
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