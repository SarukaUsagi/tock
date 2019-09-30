/*
 * Copyright (C) 2017 VSCT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ai.tock.nlp.entity.date

import org.junit.jupiter.api.Test
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import kotlin.test.assertEquals

/**
 *
 */
class DateEntityGrainTest {

    @Test
    fun calculateEnd_WithDayGrain_ReturnsTimeEqualsToLocalTimeMin() {
        val now = ZonedDateTime.now()
        val end = DateEntityGrain.day.calculateEnd(now, ZoneId.systemDefault())
        assertEquals(now.plusDays(1).dayOfYear, end.dayOfYear)
        assertEquals(LocalTime.MIN, end.toLocalTime())
    }
}