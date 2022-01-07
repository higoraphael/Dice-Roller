package com.example.diceroller

import org.junit.Test

import org.junit.Assert.assertTrue

/**
 *
 *
 *
 */
class ExampleUnitTest {

    @Test
    fun generates_number() {
        val dice = Dice(6)
        val rollResult = dice.roll()

        assertTrue("O valor de rollResult não estava entre 1 e 6",rollResult in 1..6)

    }

}