package com.example.jetpack6.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack6.viewmodels.ItemsViewModel
import com.example.jetpack6.viewmodels.MainViewModel

@Composable
fun Content(viewModel: MainViewModel){
    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        BotonColor()
        //Text(text = viewModel.resultState)
        if(viewModel.isLoading){
            CircularProgressIndicator()
        }else{
            Text(text = viewModel.resultState)
        }
        Button(onClick = {viewModel.bloqueoApp()}, colors = ButtonDefaults.buttonColors(containerColor = Color.Red, contentColor = Color.White)) {
            Text(text = "Llamada a Api con bloqueo.")
        }
        Button(onClick = {viewModel.fetchData()}) {
            Text(text = "Llamada a Api con hilo.")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BotonColor(){
    var color by remember { mutableStateOf(false)}
    Button(onClick = {color = !color}, colors = ButtonDefaults.buttonColors(
        containerColor = if(color) Color.Blue else Color.Red
    )) {
        Text(text = "Cambiar Color")
    }
}

@Composable
fun ContentWithList(viewModel: ItemsViewModel){
    val itemsList = viewModel.itemList
    val lista by viewModel.lista.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    if(viewModel.isLoading){
        CircularProgressIndicator()
    }else{
        /*
        LazyColumn {
            items(lista){ item ->
                Text(text = "id : " + item.id.toString())
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Nombre : " + item.name)
                Spacer(modifier = Modifier.height(8.dp))

            }
        }

         */
        //Automatico
        LazyColumn(modifier = Modifier.fillMaxSize().padding(start = 20.dp, bottom = 40.dp)) {
            items(lista){ item ->
                Text(text = "id : " + item.id.toString())
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Nombre : " + item.name)
                Spacer(modifier = Modifier.height(8.dp))

            }
        }


    }
}