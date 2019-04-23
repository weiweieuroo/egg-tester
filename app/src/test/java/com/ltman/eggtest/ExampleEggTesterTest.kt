package com.ltman.eggtest

import com.ltman.eggtest.runner.EggTestRunner
import com.ltman.eggtest.tester.ExampleEggTester
import org.junit.Test

class ExampleEggTesterTest {

    @Test
    fun checkTesterCorrectness() {

        for (numberOfFloor in IntRange(0, 100)) {
            for (eggBrokenFloor in IntRange(0, numberOfFloor+1)) {
                val tester = ExampleEggTester()
                val testRunner = EggTestRunner(
                    numberOfFloor,
                    2,
                    eggBrokenFloor,
                    tester
                )
                assert(testRunner.testerIsCorrect == true) { "Fail at numberOfFloor: $numberOfFloor, brokenAt: $eggBrokenFloor" }
            }

        }

    }

    @Test
    fun checkTesterPerformance() {
        var totalTestCount = 0
        for (numberOfFloor in IntRange(0, 100)) {
            for (eggBrokenFloor in IntRange(0, numberOfFloor+1)) {
                val testRoundCount = arrayOf(0, 0)
                for (testRound in IntRange(0, 1)) {
                    val tester = ExampleEggTester()
                    val testRunner = EggTestRunner(
                        numberOfFloor,
                        2,
                        eggBrokenFloor,
                        tester
                    )
                    assert(testRunner.testerIsCorrect == true) { "Fail at numberOfFloor: $numberOfFloor, brokenAt: $eggBrokenFloor --> Reason incorrect result" }
                    testRoundCount[testRound] = testRunner.testCount
                }
                assert(testRoundCount[0] == testRoundCount[1]) { "Fail at numberOfFloor: $numberOfFloor, brokenAt: $eggBrokenFloor --> Reason indetermistic algorithm" }
                totalTestCount += testRoundCount[0]
            }
        }
        print("Total test count: $totalTestCount")
    }

}