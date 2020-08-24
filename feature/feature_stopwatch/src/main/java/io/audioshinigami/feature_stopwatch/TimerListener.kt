package io.audioshinigami.feature_stopwatch

interface TimerListener {

    fun updateTime(value: Long)

    fun getStartTime(): Long

    fun setTimerIsRunning(value: Boolean)

}