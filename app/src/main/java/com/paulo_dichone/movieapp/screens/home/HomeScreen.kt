package com.paulo_dichone.movieapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.paulo_dichone.movieapp.model.Movie
import com.paulo_dichone.movieapp.model.getMovie
import com.paulo_dichone.movieapp.navigation.MovieScreen
import com.paulo_dichone.movieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 1.dp
        ) {
            Text(text = "Movies")
        }
    }) {
        Column(modifier = Modifier.padding(it)) {
            MainContent(navController = navController)
        }
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovie()
) {
    Column(modifier = Modifier.padding(16.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreen.DetailScreen.name + "/$movie")
//                    Log.d("mov", "MainContent: $movie")
                }
            }
        }
    }

}
