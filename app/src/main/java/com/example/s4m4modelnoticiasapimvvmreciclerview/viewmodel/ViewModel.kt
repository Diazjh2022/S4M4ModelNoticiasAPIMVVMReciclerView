package com.example.s4m4modelnoticiasapimvvmreciclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.s4m4modelnoticiasapimvvmreciclerview.repository.interactor.NoticiasInteractor
import com.example.s4m4modelnoticiasapimvvmreciclerview.repository.retrofit.Noticias
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {

    val noticias: MutableLiveData<Noticias> = MutableLiveData()
    private val interactor = NoticiasInteractor()

    fun obBtnTraerNoticias() {
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerRespuesta("es"))
        }
    }

    fun obBtnCnn() {
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerRespuestacnn("en"))
        }
    }

    fun obBtnBbc() {
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerRespuestabbc("en"))
        }



    }
    fun obBtndeportes(){
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerRespuestadeportes("en"))
        }
    }
}