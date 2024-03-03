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

    fun selectBook(idx: Int) {
        val book = uiState.value.books.find { it.index == idx }
        _uiState.value = _uiState.value.copy(
            selectedBook = book,
            showsDetail = true
        )
    }
    fun hideDetail() {
        _uiState.value = _uiState.value.copy(
            selectedBook = _uiState.value.books.first(),
            showsDetail = false
        )
    }
}

data class HomeUIState(
    val books: List<Book> = emptyList(),
    val selectedBook: Book? = null,
    val showsDetail: Boolean = false,
)