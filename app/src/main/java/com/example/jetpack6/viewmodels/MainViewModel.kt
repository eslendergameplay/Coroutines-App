package com.example.jetpack6.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel(){
    var resultState by mutableStateOf("")
        private set
    var isLoading by mutableStateOf(false)
        private set

    fun bloqueoApp(){
        Thread.sleep(5000)
        resultState = "Respuesta de la Api."
    }

    fun fetchData(){
        viewModelScope.launch {
            try{
                isLoading = true
                llamarApi()
            }catch (e:Exception){
                println("Error de ${e.message}")
            }finally {
                isLoading = false
            }

            /*v1
            val result = withContext(Dispatchers.IO){
                delay(5000)
                "Respuesta de la Api."
            }
            resultState = result
           */
        }

    }

    private suspend fun llamarApi(){
        val result = withContext(Dispatchers.IO){
            delay(5000)
            "Respuesta de la Api"
        }
        resultState = result
    }
}