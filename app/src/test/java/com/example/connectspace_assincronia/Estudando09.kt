package com.example.connectspace_assincronia
//SEM TURBINE_01
// Importações necessárias
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.*

fun main() = runTest {
    // Define o fluxo
    val fluxo = flow {
        println("Iniciando emissao do fluxo...")
        emit("Carregando dados...") // Primeiro valor
        println("Valor 'Carregando dados...' emitido")
        delay(500)
        emit("Processando dados...") // Segundo valor
        println("Valor 'Processando dados...' emitido")
        delay(500)
        emit("Dados concluidos!") // Terceiro valor
        println("Valor 'Dados concluidos!' emitido")
        println("Emissao do fluxo concluida")
    }

    // Coleta os valores emitidos manualmente
    println("Iniciando o teste do fluxo...")
    val resultados = mutableListOf<String>()
    fluxo.collect { valor ->
        println("Valor recebido pelo coletor: $valor")
        resultados.add(valor) // Armazena o valor na lista
        println("Valor armazenado na lista de resultados")
    }

    // Valida os resultados
    println("Validando os resultados coletados...")
    assert(resultados.size == 3) { "O fluxo deveria ter emitido 3 itens, mas emitiu ${resultados.size}" }
    println("Validacao: Numero correto de itens emitidos")
    assert(resultados[0] == "Carregando dados...") { "Esperado: 'Carregando dados...', Recebido: '${resultados[0]}'" }
    println("Validacao: Primeiro valor correto")
    assert(resultados[1] == "Processando dados...") { "Esperado: 'Processando dados...', Recebido: '${resultados[1]}'" }
    println("Validacao: Segundo valor correto")
    assert(resultados[2] == "Dados concluidos!") { "Esperado: 'Dados concluidos!', Recebido: '${resultados[2]}'" }
    println("Validacao: Terceiro valor correto")

    println("Teste do fluxo concluido com sucesso!")
}
