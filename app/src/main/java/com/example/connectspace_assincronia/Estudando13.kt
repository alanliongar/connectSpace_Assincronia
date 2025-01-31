package com.example.connectspace_assincronia

import kotlin.concurrent.thread

fun main() {
    println("Início - Thread principal: ${Thread.currentThread().name}")

    val t = thread {
        println("Executando em uma nova thread: ${Thread.currentThread().name}")
    }

    t.join() // Espera a thread terminar antes de sair
    println("Fim - Thread principal: ${Thread.currentThread().name}")
}

