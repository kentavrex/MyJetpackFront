package com.example.myjetpackfront.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myjetpackfront.data.stock.Stock
import com.example.myjetpackfront.ui.stocks.ProfileUiState
import com.example.myjetpackfront.ui.stocks.StocksUiState

@Composable
fun HomeScreen(
    stocksUiState: StocksUiState,
    profileUiState: ProfileUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    onStockClick: (Stock) -> Unit
) {
    when (profileUiState) {

        is ProfileUiState.Loading -> LoadingScreen(modifier)
        is ProfileUiState.Success -> {
            val userInfo = (profileUiState as ProfileUiState.Success).getUserInfo
            ProfileScreen(
                userInfo = userInfo,
                modifier = modifier
            )
        }
        is ProfileUiState.Error -> ErrorScreen(retryAction = retryAction)
    }
    when (stocksUiState) {
        is StocksUiState.Loading -> LoadingScreen(modifier)
        is StocksUiState.Success -> StocksGridScreen(
            stocks = (stocksUiState as? StocksUiState.Success)?.stockSearch ?: emptyList(),
            modifier = modifier,
            onStockClick = onStockClick
        )
        is StocksUiState.Error -> ErrorScreen(retryAction = retryAction)
    }
}