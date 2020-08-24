package io.audioshinigami.feature_stopwatch

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import timber.log.Timber

class Watch(
    private val listener: TimerListener,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): Timer {

    override var isTimerRunning: Boolean = false

    override suspend fun start() = withContext(dispatcher) {
        isTimerRunning = true
        // TODO error is here
        while (isTimerRunning){
            delay(50L)
            listener.updateTime(50L)
        }
    }

    override suspend fun pause() = withContext(dispatcher){
        isTimerRunning = false
    }

    override suspend fun reset() = withContext(dispatcher){
        pause()
        listener.updateTime(0L)
    }

    override fun setTimerIsRunning(value: Boolean) {
        isTimerRunning = value
    }
}