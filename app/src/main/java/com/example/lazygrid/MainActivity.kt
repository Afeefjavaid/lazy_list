package com.example.lazygrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazygrid.ui.theme.LazyGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyGridTheme {
                val state = rememberLazyGridState(initialFirstVisibleItemIndex = 99)
              //  state.animateScrollToItem(index = 99, scrollOffset = 99)
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(100.dp),
                    state = state,
                    content = {
                        items(100){i ->
                            Box(
                                modifier = Modifier.padding(8.dp)
                                    .aspectRatio(1f)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(Color.Green),
                                contentAlignment = Alignment.Center
                            ){
                                Text("item $i")
                            }
                        }
                    }
                )
            }
        }
    }
}
