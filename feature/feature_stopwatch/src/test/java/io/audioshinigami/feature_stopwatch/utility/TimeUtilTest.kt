/*
 * MIT License
 *
 * Copyright (c) 2020 David O.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.audioshinigami.feature_stopwatch.utility

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

@ExperimentalCoroutinesApi
class TimeUtilTest{

    @Test
    fun zeroMilliSeconds_returnsDefaultValue() = runBlockingTest {
        // Arrange: create expected result
        val expectedResult = "00:00:00"

        // Act:
        val result = TimeUtil.getTimeFormat(0L)

        // Assert:
        assertThat(result, `is`(expectedResult) )
    }

    @Test
    fun fiveSeconds_returnsCorrectValue() = runBlockingTest {
        // Arrange: create expected result
        val expectedResult = "00:00:05"

        // Act:
        val result = TimeUtil.getTimeFormat(5000L)

        // Assert:
        assertThat(result, `is`(expectedResult) )
    }

    @Test
    fun oneHour_returnsCorrectValue() = runBlockingTest {
        // Arrange: create expected result
        val expectedResult = "01:00:00"

        // Act:
        val result = TimeUtil.getTimeFormat(3600000L)

        // Assert:
        assertThat(result, `is`(expectedResult) )
    }

    @Test
    fun sevenHours_returnsCorrectValue() = runBlockingTest {
        // Arrange: create expected result
        val expectedResult = "07:00:00"

        // Act:
        val result = TimeUtil.getTimeFormat(25200000L)

        // Assert:
        assertThat(result, `is`(expectedResult) )
    }

    @Test
    fun twentyNineHours_returnsCorrectValue() = runBlockingTest {
        // Arrange: create expected result
        val expectedResult = "29:00:00"

        // Act:
        val result = TimeUtil.getTimeFormat(104400000L)

        // Assert:
        assertThat(result, `is`(expectedResult) )
    }

    @Test
    fun fiveHoursThirtyMinutes_returnsCorrectValue() = runBlockingTest {
        // Arrange: create expected result
        val expectedResult = "05:30:00"

        // Act:
        val result = TimeUtil.getTimeFormat(19800000L)

        // Assert:
        assertThat(result, `is`(expectedResult) )
    }

    @Test
    fun fourMinutesThirtySeconds_returnsCorrectValue() = runBlockingTest {
        // Arrange: create expected result
        val expectedResult = "00:04:30"

        // Act:
        val result = TimeUtil.getTimeFormat(270000L)

        // Assert:
        assertThat(result, `is`(expectedResult) )
    }

    @Test
    fun fiftySixSeconds_returnsCorrectValue() = runBlockingTest {
        // Arrange: create expected result
        val expectedResult = "00:00:56"

        // Act:
        val result = TimeUtil.getTimeFormat(56000L)

        // Assert:
        assertThat(result, `is`(expectedResult) )
    }

    @Test
    fun fifteenHoursFortyFiveMinutesTwentySeconds_returnsCorrectValue() = runBlockingTest {
        // Arrange: create expected result
        val expectedResult = "15:45:20"

        // Act:
        val result = TimeUtil.getTimeFormat(56720000L)

        // Assert:
        assertThat(result, `is`(expectedResult) )
    }
}