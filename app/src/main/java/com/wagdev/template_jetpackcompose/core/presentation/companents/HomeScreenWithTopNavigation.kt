package com.wagdev.template_jetpackcompose.core.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenWithTopNavigation(modifier: Modifier = Modifier) {
    val tabs = listOf("Part 1", "Part 2", "Part 3")
    var selectedTabIndex by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Home Screen with Tabs") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Tab Row for top navigation
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = Color.LightGray,
                modifier = Modifier.fillMaxWidth()
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                        },
                        text = { Text(text = title) }
                    )
                }
            }

            // Content based on the selected tab
            when (selectedTabIndex) {
                0 -> PageContent(pageTitle = "Part 1", backgroundColor = Color.Red)
                1 -> PageContent(pageTitle = "Part 2", backgroundColor = Color.Green)
                2 -> PageContent(pageTitle = "Part 3", backgroundColor = Color.Blue)
            }
        }
    }
}

@Composable
fun PageContent(pageTitle: String, backgroundColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = pageTitle, color = Color.White)
    }
}
