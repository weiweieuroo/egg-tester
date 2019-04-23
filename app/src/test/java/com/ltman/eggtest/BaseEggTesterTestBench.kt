package com.ltman.eggtest

import com.ltman.eggtest.runner.EggTestRunner
import com.ltman.eggtest.tester.EggTesterInterface
import com.ltman.eggtest.tester.ExampleEggTester
import org.junit.Test

open class BaseEggTesterTestBench {

    protected fun correctnessTestBench(maxFloor: Int, createEggTester: () -> EggTesterInterface) {
        for (numberOfFloor in IntRange(0, maxFloor)) {
            for (eggBrokenFloor in IntRange(0, numberOfFloor + 1)) {
                val tester = createEggTester()
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

    protected fun performanceTestBench(maxFloor: Int, createEggTester: () -> EggTesterInterface): Int {
        var totalTestCount = 0
        for (numberOfFloor in IntRange(0, maxFloor)) {
            for (eggBrokenFloor in IntRange(0, numberOfFloor+1)) {
                val testRoundCount = arrayOf(0, 0)
                for (testRound in IntRange(0, 1)) {
                    val tester = createEggTester()
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
        return totalTestCount
    }
}