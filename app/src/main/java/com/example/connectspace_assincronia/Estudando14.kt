package com.example.connectspace_assincronia

import kotlinx.coroutines.*
//Exemplo de definição da coroutines
fun main() = runBlocking {
    println("Início - Thread: ${Thread.currentThread().name}")

    launch {
        println("Corrotina iniciada - Thread: ${Thread.currentThread().name}")
        delay(1000) // Suspende aqui sem bloquear a thread
        println("Corrotina retomada - Thread: ${Thread.currentThread().name}")
    }

    println("Fim da função main() - Thread: ${Thread.currentThread().name}")
}
