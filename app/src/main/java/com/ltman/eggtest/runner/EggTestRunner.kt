package com.ltman.eggtest.runner

import com.ltman.eggtest.tester.EggTesterInterface

class EggTestRunner(
    numberOfFloor: Int,
    numberOfEgg: Int,
    private val eggBrokenAtFloor: Int,
    tester: EggTesterInterface
) {

    var testCount: Int = 0
        private set

    var eggUsedCount: Int = 0
        private set

    var testerIsCorrect: Boolean? = null
        private set

    init {
        var stopTestByTester = false
        while (eggUsedCount < numberOfEgg && !stopTestByTester) {
            tester.getNextTestFloor(numberOfFloor, numberOfEgg - eggUsedCount)?.let {
                testFloor ->
                if (testFloor < eggBrokenAtFloor) {
                    tester.reportResult(testFloor, false)
                }
                else {
                    tester.reportResult(testFloor, true)
                    eggUsedCount++
                }
                testCount++
            } ?: run {
                stopTestByTester = true
            }
        }
        val testerResult = tester.getEggTestResult()
        testerIsCorrect = testerResult == eggBrokenAtFloor
    }
}