package com.example.jetpack6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpack6.ui.theme.JetPack6Theme
import com.example.jetpack6.viewmodels.ItemsViewModel
import com.example.jetpack6.viewmodels.MainViewModel
import com.example.jetpack6.views.Content
import com.example.jetpack6.views.ContentWithList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //val viewModel:MainViewModel by viewModels()
        val viewModel2 : ItemsViewModel by viewModels()
        setContent {
            JetPack6Theme {
                Surface(modifier = Modifier.fillMaxSize(),color= MaterialTheme.colorScheme.background) {
                    //Content(viewModel)
                    ContentWithList(viewModel2)
                }
            }
        }
    }
}



