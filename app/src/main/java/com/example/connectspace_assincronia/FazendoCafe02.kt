package com.example.connectspace_assincronia
//Café assíncrono
import kotlinx.coroutines.*

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    println("Início do processo de fazer cafe - Assincrono | Hora: ${getCurrentTime()}")

    val pessoa1 = launch {
        pegarPanelinha()
        colocarAguaNaPanelinha()
        colocarPanelinhaNoFogao()
        ligarFogao()
        aguardarFervuraDaAgua()
    }

    val pessoa2 = launch {
        separarKit()
        colocarFiltroNoFunilEPosicionar()
        colocarPoNoFiltro()
    }

    pessoa1.join()
    pessoa2.join()

    launch {
        despejarAguaNoCafe()
        aguardarPassagemCompletaDoCafe()
        servirCafe()
    }.join()

    val endTime = System.currentTimeMillis()
    println("Café pronto! Processo concluido.")
    println("A tarefa completa demorou ${calculateElapsedTime(startTime, endTime)}.")
}

// Funções suspensas reutilizadas do exemplo anterior
