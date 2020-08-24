package io.audioshinigami.feature_stopwatch.utility

import java.util.concurrent.TimeUnit

/**
 * @author David O
 * Converter object to convert milliseconds to readable time format hh:mm:ss
 * @param milliSecond elapsed time in milli seconds
 */

object TimeUtil {

    fun getTimeFormat(milliSecond: Long): String {
        return String.format(
            "%02d:%02d:%02d",
            TimeUnit.MILLISECONDS.toHours(milliSecond),
            TimeUnit.MILLISECONDS.toMinutes(milliSecond) % TimeUnit.HOURS.toMinutes(1),
            TimeUnit.MILLISECONDS.toSeconds(milliSecond) % TimeUnit.MINUTES.toSeconds(1)
        )
    }
}