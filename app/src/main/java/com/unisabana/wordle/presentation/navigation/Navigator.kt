package com.unisabana.wordle.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unisabana.wordle.data.ScoreRepository
import com.unisabana.wordle.data.WordleDatabase
import com.unisabana.wordle.presentation.screens.game.GameScreen
import com.unisabana.wordle.presentation.screens.HomeScreen
import com.unisabana.wordle.presentation.screens.ScoreScreen
import com.unisabana.wordle.presentation.screens.game.GameViewModel
import kotlinx.serialization.Serializable

@Composable
fun AppNavigator(){

    val context = LocalContext.current

    val navController = rememberNavController();
    val database = remember { WordleDatabase.getDatabase(context) }
    val repository = remember { ScoreRepository(database.ScoreDao()) }
    val viewModel = remember { GameViewModel(repository) }

    NavHost(navController = navController, startDestination = HomeDestination){
        composable<HomeDestination> {
            HomeScreen(
             onPlay ={
                 navController.navigate(GameDestination)
             },
                onLeaderBoard = {
                    navController.navigate(ScoreDestination)
                }
            )

        }
        composable<GameDestination> {
            GameScreen(navController,viewModel)
        }
        composable<ScoreDestination> {
            ScoreScreen(
                onBack = {
                    navController.popBackStack()
                },
                viewModel

            )
        }
    }
}

@Serializable
object HomeDestination

@Serializable
object GameDestination

@Serializable
object ScoreDestination
