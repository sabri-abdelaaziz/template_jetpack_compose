package com.wagdev.template_jetpackcompose.core.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.AddBusiness
import androidx.compose.material.icons.filled.AddCard
import androidx.compose.material.icons.filled.BusinessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AddBusiness
import androidx.compose.material.icons.outlined.BusinessCenter
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.wagdev.template_jetpackcompose.R
import com.wagdev.template_jetpackcompose.core.presentation.companents.DrawerContent
import com.wagdev.template_jetpackcompose.core.presentation.companents.HomeScreen
import com.wagdev.template_jetpackcompose.core.presentation.companents.TopAppBarSection
import com.wagdev.template_jetpackcompose.core.presentation.components.HomeScreenWithTopNavigation


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(navController: NavController, initialSelectedItem: Int) {
    var selectedItem by remember { mutableStateOf(initialSelectedItem) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()


    val itemButton = listOf(
        BottomItem(
            title = stringResource(R.string.home),
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            badgeNum = 0,
            hasBadge = false
        ),
        BottomItem(
            title = stringResource(R.string.home),
            selectedIcon = Icons.Filled.AddBusiness,
            unselectedIcon = Icons.Outlined.AddBusiness,
            badgeNum = 0,
            hasBadge = false
        ),
        BottomItem(
            title = stringResource(R.string.home),
            selectedIcon = Icons.Filled.BusinessCenter,
            unselectedIcon = Icons.Outlined.BusinessCenter,
            badgeNum = 0,
            hasBadge = false
        ),
        BottomItem(
            title = stringResource(R.string.home),
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            badgeNum = 0,
            hasBadge = false
        ),
        BottomItem(
            title = stringResource(R.string.home),
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart,
            badgeNum = 2,
            hasBadge = true
        )
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController = navController)
        },
        content = {
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        itemButton.forEachIndexed { i, e ->
                            NavigationBarItem(
                                selected = i == selectedItem,
                                onClick = { selectedItem = i },
                                icon = {
                                    BadgedBox(
                                        badge = {
                                            if (e.badgeNum > 0) {
                                                Badge { Text(e.badgeNum.toString()) }
                                            }
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (i == selectedItem) e.selectedIcon else e.unselectedIcon,
                                            contentDescription = null
                                        )
                                    }
                                },
                                label = {
                                    if (i == selectedItem) {
                                        Text(e.title)
                                    }
                                }
                            )
                        }
                    }
                },
                topBar = {
                    TopAppBarSection(navController=navController, drawerState = drawerState, scope = scope)
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {

                    }) {
                        Icon(Icons.Default.Add, contentDescription = null)
                    }
                },
                content = { paddingValues ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        when (selectedItem) {
                            0 -> HomeScreen(navController = navController,modifier=Modifier)
                            1 ->  HomeScreenWithTopNavigation()
                            2 ->  HomeScreen(navController = navController,modifier=Modifier)
                            3 ->  HomeScreen(navController = navController,modifier=Modifier)
                            4 ->  HomeScreen(navController = navController,modifier=Modifier)
                            else -> Text("Invalid selection")
                        }
                    }

                }
            )
        }
    )
}

data class BottomItem(
    val title:String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasBadge:Boolean,
    val badgeNum:Int=0,
    var isSelected:Boolean=false
)