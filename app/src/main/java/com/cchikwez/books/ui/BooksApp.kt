package com.cchikwez.books.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
            .fillMaxWidth()
    ) {
        Image(
            painterResource(id = book.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
        Text(
            text = "${book.index}. ${book.title}",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = MaterialTheme.typography.bodyLarge.fontSize * 1.2f
            )
        )
        Text(
            "Author: ${book.author}",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            "Released: ${book.released}",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        Text(
            "${book.quote}",
            style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic)
        )
        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        Text(
            "${book.synopsis}",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(Modifier.size(32.dp))
    }
}
