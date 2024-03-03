package com.cchikwez.books.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cchikwez.books.data.Book
import com.cchikwez.books.ui.theme.BooksTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import com.cchikwez.books.R
import com.cchikwez.books.data.BookTestData

@Composable
fun DetailScreen(
    book: Book,
    hideDetail: () -> Unit,
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(vertical = 8.dp)
            ) {
                val imgModifier = Modifier
                    .aspectRatio(1f)
                Image(
                    painterResource(id = book.image),
                    contentDescription = null,
                    modifier = imgModifier
                )
            }

            Column {
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
                Text(
                    "${book.synopsis}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        Spacer(Modifier.size(24.dp))

        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = hideDetail
            ) {
                Text(stringResource(id = R.string.back))
            }
        }
    }
}


@Preview
@Composable
fun DetailScreenPreview() {
    BooksTheme() {
        Surface(tonalElevation = 5.dp) {
            DetailScreen(book = BookTestData.allBooks.get(1), hideDetail = { })
        }
    }
}
