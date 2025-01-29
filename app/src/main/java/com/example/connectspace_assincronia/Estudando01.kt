package com.example.connectspace_assincronia

import kotlinx.coroutines.*
import java.lang.*

/*
* 1 - O objetivo desse programa é só declarar duas threads
* de baixo nível, e observar o comportamento delas no terminal.
* */

fun main() {
    var resultado: Int? = null // Variável para capturar o valor retornado
    var resultado2: Int? = null
    println("01 - O nome da thread eh: ${Thread.currentThread().name}")
    val thread = Thread {
        println("02 - O nome da thread eh: ${Thread.currentThread().name}")
        runBlocking {
            println("03 - O nome da thread eh: ${Thread.currentThread().name}")
            delay(1000)
            resultado = 50 // Atribui o valor 50 à variável compartilhada
        }
    }

    val thread2 = Thread {
        println("04 - O nome da thread eh: ${Thread.currentThread().name}")
        runBlocking {
            println("05 - O nome da thread eh: ${Thread.currentThread().name}")
            delay(1000)
            resultado2 = 65 // Atribui o valor 50 à variável compartilhada
        }
    }
    thread.start()
    thread.join()
    thread2.start()
    thread2.join()

    println("06 - O nome do tipo da variavel eh: ${thread::class.simpleName}")
    println("07 - O valor da variavel eh: ${thread}")
    println("08 - O resultado da execucao eh: $resultado") // Imprime o valor capturado
    println("09 - O nome do tipo da variavel eh: ${thread2::class.simpleName}")
    println("10 - O valor da variavel eh: ${thread2}")
    println("11 - O resultado da execucao eh: $resultado2") // Imprime o valor capturado
}