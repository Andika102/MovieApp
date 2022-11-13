package com.paulo_dichone.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.paulo_dichone.movieapp.model.Movie
import com.paulo_dichone.movieapp.model.getMovie
import com.paulo_dichone.movieapp.widgets.MovieRow

@Composable
fun DetailScreen(navController: NavController, movieId: String?) {
    val newMovieList = getMovie().filter { movie ->
        movie.id == movieId
    }
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.LightGray, elevation = 5.dp) {
            Row {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movies")
            }
        }
    }) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(it)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                MovieRow(movie = newMovieList.first())
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Movie Images")
                xScrollableImages(newMovieList)

            }
        }
    }

}

@Composable
private fun xScrollableImages(newMovieList: List<Movie>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(height = 200.dp, width = 260.dp), elevation = 5.dp
            ) {
                AsyncImage(
                    model = image,
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "Movie Poster"
                )
            }
        }
    }
}