package com.example.connectspace_assincronia

import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    println("Inicio do processo de fazer cafe - Sincrono | Hora: ${getCurrentTime()}")

    pegarPanelinha()
    colocarAguaNaPanelinha()
    colocarPanelinhaNoFogao()
    ligarFogao()
    aguardarFervuraDaAgua()
    separarKit()
    colocarFiltroNoFunilEPosicionar()
    colocarPoNoFiltro()
    despejarAguaNoCafe()
    aguardarPassagemCompletaDoCafe()
    servirCafe()

    val endTime = System.currentTimeMillis()
    println("Cafe pronto! Processo concluido.")
    println("A tarefa completa demorou ${calculateElapsedTime(startTime, endTime)}.")
}

suspend fun pegarPanelinha() {
    logStep("01 - Pegando a panelinha...")
    delay(500)
}

suspend fun colocarAguaNaPanelinha() {
    logStep("02 - Colocando agua na panelinha...")
    delay(500)
}

suspend fun colocarPanelinhaNoFogao() {
    logStep("03 - Colocando a panelinha no fogao...")
    delay(500)
}

suspend fun ligarFogao() {
    logStep("04 - Ligando o fogao...")
    delay(500)
}

suspend fun aguardarFervuraDaAgua() {
    logStep("05 - Aguardando a fervura da agua...")
    delay(2000)
}

suspend fun separarKit() {
    logStep("06 - Separando o funil, filtro e jarrinho...")
    delay(500)
}

suspend fun colocarFiltroNoFunilEPosicionar() {
    logStep("07 - Colocando o filtro no funil e posicionando no jarrinho...")
    delay(500)
}

suspend fun colocarPoNoFiltro() {
    logStep("08 - Colocando o po de cafe no filtro...")
    delay(500)
}

suspend fun despejarAguaNoCafe() {
    logStep("09 - Despejando a agua quente no cafe...")
    delay(1000)
}

suspend fun aguardarPassagemCompletaDoCafe() {
    logStep("10 - Aguardando a passagem completa do cafe pelo filtro...")
    delay(1500)
}

suspend fun servirCafe() {
    logStep("11 - Servindo o cafe (com ou sem acucar)...")
    delay(500)
}

// Funções auxiliares
fun getCurrentTime(): String {
    val formatter = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())
    return formatter.format(Date())
}

fun calculateElapsedTime(startTime: Long, endTime: Long): String {
    val elapsedTime = endTime - startTime
    val seconds = elapsedTime / 1000
    val milliseconds = elapsedTime % 1000
    return "$seconds segundos e $milliseconds milissegundos"
}

fun logStep(message: String) {
    println("$message | Hora: ${getCurrentTime()}")
}
