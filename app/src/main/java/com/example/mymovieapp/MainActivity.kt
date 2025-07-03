package com.example.mymovieapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mymovieapp.features.detail.DetailScreen
import com.example.mymovieapp.features.feed.FeedScreen
import com.example.mymovieapp.ui.theme.MyMovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        private const val IMDB_BASE_URL = "https://m.imdb.com"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContent {
            MyMovieAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "feed"
                ) {
                    composable("feed") {
                        FeedScreen(navController)
                    }
                    composable("detail/{movieName}") { navBackStackEntry ->
                        val movieName = navBackStackEntry.arguments?.getString("movieName") ?: ""
                        DetailScreen(
                            movieName = movieName,
                            navController = navController,
                            openUrl = { url ->
                                startActivity(
                                    Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(IMDB_BASE_URL + url)
                                    )
                                )
                            }
                        )
                    }
                    composable("info") {
                        FeedScreen(navController)
                    }
                }
            }
        }
    }
}