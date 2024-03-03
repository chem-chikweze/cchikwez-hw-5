package com.cchikwez.books.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cchikwez.books.data.Book

@Composable
fun BooksApp(homeUIState: HomeUIState, modifier: Modifier){
    BookList(books = homeUIState.books)
}

@Composable
fun BookList(books: List<Book>) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(
            items = books,
            itemContent = { book ->
                BookItem(book = book)
            }
        )
    }
}

@Composable
fun BookItem(book: Book) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
    ) {
        Image(
            painterResource(id = book.image),
            contentDescription = null
        )
        Text(
            text = "$book.index}. ${book.title}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "Author: ${book.author}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            "Released: ${book.released}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            "${book.quote}",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            "${book.synopsis}",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(Modifier.size(32.dp))
    }
}
