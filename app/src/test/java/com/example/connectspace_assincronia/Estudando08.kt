package com.example.connectspace_assincronia
//COM TURBINE

import app.cash.turbine.test
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.*

fun main() = runTest { //exemplo COM TURBINE
    // Cria um fluxo que emite dois valores com um atraso entre eles
    val fluxo = flow {
        println("Emitindo valor 1")
        emit(1) // Emite o primeiro valor
        delay(500) // Aguarda 500ms
        println("Emitindo valor 2")
        emit(2) // Emite o segundo valor
    }

    // Testa o fluxo
    fluxo.test {
        val primeiroValor = awaitItem() // Aguarda o primeiro valor
        println("Valor recebido do fluxo: $primeiroValor")
        assert(primeiroValor == 1) // Valida o primeiro valor

        val segundoValor = awaitItem() // Aguarda o segundo valor
        println("Valor recebido do fluxo: $segundoValor")
        assert(segundoValor == 2) // Valida o segundo valor

        awaitComplete() // Verifica se o fluxo foi concluído
        println("Fluxo concluido com sucesso!")
    }
}
