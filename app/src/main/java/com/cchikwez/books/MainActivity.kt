package com.cchikwez.books

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cchikwez.books.data.BookTestData
import com.cchikwez.books.ui.BooksApp
import com.cchikwez.books.ui.BooksVM
import com.cchikwez.books.ui.HomeUIState
import com.cchikwez.books.ui.screens.HomeScreen
import com.cchikwez.books.ui.theme.BooksTheme

class MainActivity : ComponentActivity() {
    private val viewModel: BooksVM by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val uiState by viewModel.uiState.collectAsState()

            BooksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BooksApp(
                        homeUIState = uiState,
                        selectBook = {
                            viewModel.selectBook(it)
                        },
                        hideDetail = {
                            viewModel.hideDetail()
                        }
                    )
                }
            }
        }
    }
}


//
//@Preview(showBackground = true)
//@Composable
//fun BooksAppPreview() {
//    BooksTheme {
//        Surface(tonalElevation = 5.dp) {
//            BooksApp(homeUIState = HomeUIState(books = BookTestData.allBooks))
//        }
//    }
//}