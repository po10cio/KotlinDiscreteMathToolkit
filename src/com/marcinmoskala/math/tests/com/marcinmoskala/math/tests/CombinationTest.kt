package com.marcinmoskala.math.tests

import com.marcinmoskala.math.allCombinations
import com.marcinmoskala.math.combinationNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CombinationTest {

    @Test fun `Test combinationsNumber for Sets with different sizes`() {
        val set = setOf(1, 2, 3, 4)
        val subsetSizeToCombinationNumber = mapOf(
                0 to 0L,
                1 to 4L,
                2 to 6L,
                3 to 4L,
                4 to 1L,
                5 to 1L
        )
        for ((subsetSize, expectedCombinationNumber) in subsetSizeToCombinationNumber) {
            assertEquals(expectedCombinationNumber, set.combinationNumber(subsetSize))
        }
    }

    @Test fun `Test allCombinations for Sets with different sizes`() {
        val set = setOf(1, 2, 3, 4)
        val sizeToCombinations = mapOf(
                0 to setOf<Set<Int>>(),
                1 to setOf(setOf(1), setOf(2), setOf(3), setOf(4)),
                2 to setOf(setOf(1, 2), setOf(2, 3), setOf(3, 4), setOf(1, 3), setOf(2, 4), setOf(1, 4)),
                3 to setOf(setOf(1, 2, 3), setOf(1, 2, 4), setOf(1, 3, 4), setOf(2, 3, 4)),
                4 to setOf(setOf(1, 2, 3, 4)),
                5 to setOf(setOf(1, 2, 3, 4))
        )
        for ((subsetSize, expectedCombinations) in sizeToCombinations) {
            assertEquals(expectedCombinations, set.allCombinations(subsetSize))
        }
    }



    @Test fun `Test allCombinations size and combinationsNumber correctness`() {
        val set = (1..6).toSet()
        (1..7).forEach { i -> assertEquals(set.combinationNumber(i), set.allCombinations(i).size.toLong()) }
    }
}