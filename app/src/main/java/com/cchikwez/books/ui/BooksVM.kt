package com.cchikwez.books.ui

import androidx.lifecycle.ViewModel
import com.cchikwez.books.data.Book
import com.cchikwez.books.data.BookTestData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BooksVM: ViewModel() {

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState : StateFlow<HomeUIState> = _uiState

    init {
        initList()
    }

    private fun initList() {
        val books = BookTestData.allBooks
        _uiState.value = HomeUIState(
            books = books
        )
    }
}

data class HomeUIState(
    val books: List<Book> = emptyList()
)