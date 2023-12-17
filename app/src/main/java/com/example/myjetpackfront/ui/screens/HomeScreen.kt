package com.example.myjetpackfront.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myjetpackfront.data.stock.Stock
import com.example.myjetpackfront.ui.stocks.StocksUiState

@Composable
fun HomeScreen(
    stocksUiState: StocksUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    onStockClick: (Stock) -> Unit
) {
    when (stocksUiState) {
        is StocksUiState.Loading -> LoadingScreen(modifier)
        is StocksUiState.Success, is StocksUiState.ProfileClose -> StocksGridScreen(
            stocks = (stocksUiState as? StocksUiState.Success)?.stockSearch ?: emptyList(),
            modifier = modifier,
            onStockClick = onStockClick
        )
        is StocksUiState.Error -> ErrorScreen(retryAction = retryAction)
        is StocksUiState.Profile -> ProfileScreen()

    }
}