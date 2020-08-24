package io.audioshinigami.feature_stopwatch

interface Timer {

    var isTimerRunning: Boolean

    suspend fun start()

    suspend fun pause()

    suspend fun reset()

    fun setTimerIsRunning(value: Boolean)
}