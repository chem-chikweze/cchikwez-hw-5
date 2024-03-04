package com.cchikwez.books.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cchikwez.books.data.Book
import com.cchikwez.books.ui.theme.BooksTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.layout.ContentScale
import com.cchikwez.books.data.BookTestData
import com.cchikwez.books.ui.BooksApp
import com.cchikwez.books.ui.HomeUIState


@Composable
fun HomeScreen(
    homeUIState: HomeUIState,
    selectBook: (Int) -> Unit
){
    BookList(books = homeUIState.books, selectBook)
}

@Composable
fun BookList(books: List<Book>, selectBook: (Int) -> Unit) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(
            items = books,
            itemContent = { book ->
                BookItem(book = book, selectBook)
            }
        )
    }
}

@Composable
fun BookItem(
    book: Book,
    selectBook: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .clickable { selectBook(book.index) },
    ) {
        val imgModifier = Modifier
            .size(72.dp)
        Row {
            Image(
                painterResource(id = book.image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = imgModifier
            )
            Spacer(Modifier.width(12.dp))
            Column {
                Text(
                    text = "${book.index}. ${book.title}",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize * 1.2f
                    )
                )
                Text(
                    "Author: ${book.author}",
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    "Released: ${book.released}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
        Spacer(Modifier.height(12.dp))
        Text(
            "${book.quote}",
            style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic)
        )
        Spacer(modifier = Modifier.padding(bottom = 16.dp))
    }
}

@Preview
@Composable
fun ContentPreview() {
    BooksTheme() {
        Surface(tonalElevation = 5.dp) {
            HomeScreen(
                homeUIState = HomeUIState(books = BookTestData.allBooks),
                selectBook = {}
            )
        }
    }
}
