package com.example.myjetpackfront.data.user

import com.example.myjetpackfront.UserDto
import com.example.myjetpackfront.network.UserService


interface UsersRepository {
    suspend fun getUserInfo(userId: Int): User
}


class NetworkUserRepository(
    private val userService: UserService
): UsersRepository {
    override suspend fun getUserInfo(userId: Int): User {

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
        val userResponse: UserDto = UserDto("Амир",
            arrayListOf("2шт: AAPL: 23.12▲", "45шт: CNK: 43.53▲", "23шт: GOOG: 143.52▼", "13шт: SHELL: 22.11▲")
            )
//        val user = userResponse.map { data ->
//            User(
//                name = data.name,
//                price = data.price,
//                imgLink = data.imgLink
//            )
//        }

        return User(
            name="Амир",
            tickers=arrayListOf("2шт: AAPL: 23.12▲", "45шт: CNK: 43.53▲", "23шт: GOOG: 143.52▼", "13шт: SHELL: 22.11▲")
        )

    }
}