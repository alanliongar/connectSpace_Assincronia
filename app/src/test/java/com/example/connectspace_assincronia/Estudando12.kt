package com.example.connectspace_assincronia
//Sem turbine - controle de tempo
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.*
import org.junit.Assert.*
import org.junit.Test

class TestandoFluxoComTempos {
    private val scheduler = TestCoroutineScheduler()
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(scheduler)

    @Test
    fun `testando valores emitidos em tempos especificos`() = runTest(testDispatcher) {
        // Cria um fluxo que emite valores com atrasos específicos
        val fluxo = flow {
            delay(500) // Espera 500ms virtuais
            emit(1) // Primeiro valor emitido
            println("Valor 1 emitido após 500ms")
            delay(200) // Espera mais 200ms
            emit(2) // Segundo valor emitido
            println("Valor 2 emitido após 700ms (500ms + 200ms)")
            delay(300) // Espera mais 300ms
            emit(4) // Terceiro valor emitido
            println("Valor 4 emitido após 1000ms (500ms + 200ms + 300ms)")
        }

        // Lista para armazenar os valores capturados no fluxo
        val resultados = mutableListOf<Pair<Long, Int>>() // (tempo em ms, valor)

        // Lança a coleta do fluxo em uma corrotina
        backgroundScope.launch(testDispatcher) { //Essa corrotina vai ser executada quando o agendador determinar!
            fluxo.collect { valor ->
                val tempoAtual = scheduler.currentTime // Captura o tempo virtual no momento da emissão
                resultados.add(tempoAtual to valor)
                println("Valor recebido: $valor no tempo virtual: ${tempoAtual}ms")
            }
        }

        // Avança o tempo virtualmente e captura os valores emitidos
        println("Avançando o tempo virtual...")
        scheduler.advanceTimeBy(1500) // Avança 1.5s no tempo virtual

        // Validações
        println("Validando os resultados...")
        assertEquals(3, resultados.size) // Verifica que 3 valores foram emitidos
        assertEquals(Pair(500L, 1), resultados[0]) // Primeiro valor emitido aos 500ms
        assertEquals(Pair(700L, 2), resultados[1]) // Segundo valor emitido aos 700ms
        assertEquals(Pair(1000L, 4), resultados[2]) // Terceiro valor emitido aos 1000ms

        println("Teste concluído com sucesso!")
    }
}

/*
Prompt ao chatgpt que gerou esse exemplo:
Será que você poderia me ensinar com detalhe a questão de testar (assertEquals)
os valores considerando os tempos deles? Talvez o testScheduler possa ajudar....
Pq tipo, se eu emito um valor pra um fluxo em 500ms, e 200ms depois da emissão do
primeiro, eu emito outro.... Sendo algo assim tipo:

delay(500)
emite 1
delay(200)
emite 2
delay(300)
emite 4

Tipo, se for com tempos assim, será que tem como eu configurar pra eu colocar pra capturar o
item "emite 1" que seria capturado entre 500 e 700 ms dps que o programa lançou? algum raciocinio
assim..... será q existe isso? talvez eu esteja viajando.
*/
