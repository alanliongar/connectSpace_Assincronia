package com.example.connectspace_assincronia
//Exemplo simples
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val fluxo = MutableStateFlow("Valor inicial")

    // Coletor simples com first()
    val result1 = fluxo.first()
    println("Resultado com first(): $result1")

    // Coletor com drop(0).first()
    val result2 = fluxo.drop(0).first()
    println("Resultado com drop(0).first(): $result2")
}
