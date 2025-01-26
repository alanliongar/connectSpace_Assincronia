package com.example.connectspace_assincronia
//Sem turbine 02
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
        var result: String? = null
        var fluxo = MutableStateFlow<String?>(null)

        // Lança uma corrotina para emitir valores no fluxo
        val emissor = backgroundScope.launch {
            delay(500)
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
            result = fluxo.drop(2).first()
            println("Valor coletado: $result")
            assertEquals("Processando dados...", result)
        }

        // Aguarda a conclusão das corrotinas
        joinAll(emissor, coletor)
        println("Teste concluído com sucesso!")
    }
}
