package com.cchikwez.books.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cchikwez.books.ui.theme.BooksTheme
import androidx.compose.material3.Surface
import com.cchikwez.books.data.BookTestData
import com.cchikwez.books.ui.screens.DetailsScreen
import com.cchikwez.books.ui.screens.HomeScreen


@Composable
fun BooksApp(
    homeUIState: HomeUIState,
    selectBook: (Int) -> Unit,
    hideDetail: () -> Unit,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (homeUIState.showsDetail) {
            homeUIState.selectedBook?.let {
                DetailsScreen(
                    book = it,
                    hideDetail
                )
            }
        } else {
            HomeScreen(
                homeUIState = homeUIState,
                selectBook = selectBook
            )
        }
    }
}


@Preview
@Composable
fun ContentPreview() {
    BooksTheme() {
        Surface(tonalElevation = 5.dp) {
            BooksApp(
                homeUIState = HomeUIState( BookTestData.allBooks),
                selectBook = {},
                hideDetail = {}
            )
        }
    }
}
