package com.example.connectspace_assincronia

// Importações necessárias
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.*
import org.junit.Assert.*
import org.junit.Test

class TestandoCodigo {
    private val scheduler = TestCoroutineScheduler()
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(scheduler)

    @Test
    fun testarCodigo() = runTest(testDispatcher) {
        // Define o fluxo
        val fluxo = MutableStateFlow("Primeiro valor emitido")
        //Note que por ser um mutablestateflow, o primeiro valor assinado a ele nunca é contado como primeiro.
        //Entender o real motivo de estar acontecendo isso aqui!

        // Lança uma corrotina para emitir valores no fluxo
        val emissor = backgroundScope.launch {
            println("Iniciando emissao do fluxo...")
            fluxo.emit("Carregando dados...") // "Primeiro valor"
            println("Valor 'Carregando dados...' emitido")
            delay(500)
            fluxo.emit("Processando dados...") // "Segundo valor"
            println("Valor 'Processando dados...' emitido")
            delay(500)
            fluxo.emit("Dados concluidos!") // "Terceiro valor"
            println("Valor 'Dados concluidos!' emitido")
            println("Emissao do fluxo concluida")
        }

        // Coleta o terceiro valor emitido
        val coletor = backgroundScope.launch {
            println("Iniciando o teste do fluxo...")
            val result = fluxo.drop(0).first() // Coleta o terceiro valor
            println("Valor coletado: $result")
            assertEquals("Processando dados...", result)
        }

        // Aguarda a conclusão das corrotinas
        emissor.join()
        coletor.join()

        println("Teste concluído com sucesso!")
    }
}
