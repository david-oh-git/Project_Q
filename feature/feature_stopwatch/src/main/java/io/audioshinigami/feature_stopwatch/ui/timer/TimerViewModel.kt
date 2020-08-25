package io.audioshinigami.feature_stopwatch.ui.timer

import androidx.lifecycle.*
import io.audioshinigami.feature_stopwatch.TimerListener
import io.audioshinigami.feature_stopwatch.Watch
import io.audioshinigami.feature_stopwatch.utility.TimeUtil
import kotlinx.coroutines.*
import timber.log.Timber

class TimerViewModel(
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Main + Job() )
): ViewModel(), TimerListener {

    private val watch = Watch(this)
    private val _timerIsRunning: MutableLiveData<Boolean> = MutableLiveData(watch.isTimerRunning)
    val timerIsRunning: LiveData<Boolean> = _timerIsRunning

    private val _runningTime = MutableLiveData(0L)
    // converts milli seconds to time format hh:mm:ss
    val runningTime: LiveData<String> = Transformations.map(_runningTime){
        TimeUtil.getTimeFormat(it)
    }

    fun timerButtonAction()  = scope.launch {
        Timber.d("button clicked")
        Timber.d("timer is running ? ${_timerIsRunning.value}")
        when(_timerIsRunning.value){
            true -> {
                _timerIsRunning.postValue(false)
                watch.pause()
            }
            false -> {
                _timerIsRunning.postValue(true)
                watch.start()
            }
        }

    }

    fun reset() = scope.launch {
        watch.pause()
        _timerIsRunning.postValue(false)
        _runningTime.postValue(0L)
        // TODO also save start time to 0L
    }

    override fun updateTime(value: Long) {
        val newValue = (_runningTime.value ?: 0L ) + value
        _runningTime.postValue(newValue)
    }

    override fun getStartTime(): Long {
        // TODO Not yet implemented
        return 0L
    }

    override fun setTimerIsRunning(value: Boolean) {
        _timerIsRunning.postValue(value)
    }

    override fun onCleared() {
        super.onCleared()
        // TODO also save time
        scope.cancel()
    }

}

@Suppress("UNCHECKED_CAST")
class TimerViewModelFactory(
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Main + Job() )
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        TimerViewModel(scope) as T
}