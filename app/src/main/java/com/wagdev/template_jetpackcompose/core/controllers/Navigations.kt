package com.wagdev.template_jetpackcompose.core.controllers

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.wagdev.template_jetpackcompose.core.presentation.Home
import com.wagdev.template_jetpackcompose.core.utils.Routes

@Composable
fun Navigations  (
    navController:NavHostController,
    modifier:Modifier=Modifier
) {
    NavHost(navController = navController, startDestination = Routes.Home.route+"/1" ){
        composable("home/{selectedItem}", arguments = listOf(navArgument("selectedItem") { type = NavType.IntType })) { backStackEntry ->
            val selectedItemIndex = backStackEntry.arguments?.getInt("selectedItem") ?: 0
            Home(navController, selectedItemIndex)
        }
    }
}