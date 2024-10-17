package com.wagdev.template_jetpackcompose.core.utils

sealed class Routes(
    val route:String
) {
    object Home:Routes("home")
    object Login:Routes("login")

}