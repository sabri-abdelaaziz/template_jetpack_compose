package com.wagdev.template_jetpackcompose.core.presentation.companents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // Pager state to manage the pager
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home Page", Modifier.padding(bottom = 16.dp))

        // Pager with 3 pages
        HorizontalPager(
            count = 3, // We want 3 pages
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            // Page content based on page number
            when (page) {
                0 -> PageContent(pageTitle = "Page 1", backgroundColor = Color.Red)
                1 -> PageContent(pageTitle = "Page 2", backgroundColor = Color.Green)
                2 -> PageContent(pageTitle = "Page 3", backgroundColor = Color.Blue)
            }
        }
    }
}

@Composable
fun PageContent(pageTitle: String, backgroundColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = pageTitle, color = Color.White)
    }
}
