package com.example.connectspace_assincronia
//Café assíncrono
import kotlinx.coroutines.*

fun main() = runBlocking() {
    val startTime = System.currentTimeMillis()

    println("Inicio do processo de fazer cafe - Assincrono | Hora: ${getCurrentTime()}")

    val pessoa1 = launch() {
        print("Pessoa 1 - ")
        pegarPanelinha()
        print("Pessoa 1 - ")
        colocarAguaNaPanelinha()
        print("Pessoa 1 - ")
        colocarPanelinhaNoFogao()
        print("Pessoa 1 - ")
        ligarFogao()
    }

    val pessoa2 = launch() {
        print("Pessoa 2 - ")
        separarKit()
        print("Pessoa 2 - ")
        colocarFiltroNoFunilEPosicionar()
        print("Pessoa 2 - ")
        colocarPoNoFiltro()
    }

    joinAll(pessoa1, pessoa2)

    /*pessoa1.join()
    pessoa2.join()*/

    launch {
        print("Pessoas - ")
        aguardarFervuraDaAgua()
        print("Pessoa 2 - ")
        despejarAguaNoCafe()
        print("Pessoa 2 - ")
        aguardarPassagemCompletaDoCafe()
        print("Pessoa 2 - ")
        servirCafe()
    }.join()

    val endTime = System.currentTimeMillis()
    println("Cafe pronto! Processo concluido.")
    println("A tarefa completa demorou ${calculateElapsedTime(startTime, endTime)}.")
}

// Funções suspensas reutilizadas do exemplo anterior
