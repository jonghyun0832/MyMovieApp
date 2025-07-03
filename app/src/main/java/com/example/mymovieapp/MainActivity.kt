package com.example.mymovieapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mymovieapp.features.detail.DetailScreen
import com.example.mymovieapp.features.dialogs.IMDBDialogScreen
import com.example.mymovieapp.features.dialogs.RatingDialogScreen
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
                        DetailScreen(movieName, navController)
                    }
                    composable("info") {
                        FeedScreen(navController)
                    }
                    composable(
                        route = "imdbDialog/{url}",
                        arguments = listOf(
                            navArgument("url") { type = NavType.StringType }
                        )
                    ) { navBackStackEntry ->
                        val encodedUrl = navBackStackEntry.arguments?.getString("url") ?: ""
                        val url = Uri.decode(encodedUrl)
                        IMDBDialogScreen(
                            action = {
                                startActivity(
                                    Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(IMDB_BASE_URL + url)
                                    )
                                )
                            },
                            onDismiss = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}