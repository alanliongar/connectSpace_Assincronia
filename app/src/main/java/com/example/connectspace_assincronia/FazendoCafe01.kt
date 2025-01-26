package com.devspacecinenow

import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    println("Início do processo de fazer cafe - Sincrono | Hora: ${getCurrentTime()}")

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
    logStep("Pegando a panelinha...")
    delay(500)
}

suspend fun colocarAguaNaPanelinha() {
    logStep("Colocando agua na panelinha...")
    delay(500)
}

suspend fun colocarPanelinhaNoFogao() {
    logStep("Colocando a panelinha no fogao...")
    delay(500)
}

suspend fun ligarFogao() {
    logStep("Ligando o fogao...")
    delay(500)
}

suspend fun aguardarFervuraDaAgua() {
    logStep("Aguardando a fervura da agua...")
    delay(2000)
}

suspend fun separarKit() {
    logStep("Separando o funil, filtro e jarrinho...")
    delay(500)
}

suspend fun colocarFiltroNoFunilEPosicionar() {
    logStep("Colocando o filtro no funil e posicionando no jarrinho...")
    delay(500)
}

suspend fun colocarPoNoFiltro() {
    logStep("Colocando o po de cafe no filtro...")
    delay(500)
}

suspend fun despejarAguaNoCafe() {
    logStep("Despejando a agua quente no cafe...")
    delay(1000)
}

suspend fun aguardarPassagemCompletaDoCafe() {
    logStep("Aguardando a passagem completa do cafe pelo filtro...")
    delay(1500)
}

suspend fun servirCafe() {
    logStep("Servindo o cafe (com ou sem acucar)...")
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
