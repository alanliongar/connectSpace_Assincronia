package com.example.connectspace_assincronia

import kotlinx.coroutines.*

/*
* 1 - O objetivo desse programa é o mesmo do anterior: lançar duas tarefas
* e observar o comportamento das threads pelas impressões do terminal
* */



fun main() = runBlocking {
    var resultado1: Int? = null
    var resultado2: Int? = null


    GlobalScope.launch(Dispatchers.IO){
        println("00 - O nome do tred eh ${Thread.currentThread().name}")
    }


    println("01 - O nome da thread eh: ${Thread.currentThread().name}")

    // Lançando a primeira corrotina
    val job1 = launch(Dispatchers.Unconfined) {
        delay(1000) // Simula uma operação assíncrona
        println("02 - O nome da thread eh: ${Thread.currentThread().name}")
        resultado1 = 50 // Atribui um valor ao resultado
    }

    // Lançando a segunda corrotina
    val job2 = launch(Dispatchers.Default) {
        delay(500) // Simula uma operação assíncrona
        println("03 - O nome da thread eh: ${Thread.currentThread().name}")
        resultado2 = 65 // Atribui um valor ao resultado
    }

    // Aguarda todas as corrotinas finalizarem
    joinAll(job1, job2)

    /*job1.join()
    job2.join()*/

    println("04 - O resultado da execucao da corrotina 1 eh: $resultado1")
    println("05 - O resultado da execucao da corrotina 2 eh: $resultado2")
}

