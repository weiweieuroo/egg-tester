package com.ltman.eggtest

import com.ltman.eggtest.tester.ExampleEggTester
import org.junit.Test

class ExampleEggTesterTest: BaseEggTesterTestBench() {

    @Test
    fun checkTesterCorrectness() {
        correctnessTestBench(100) { ExampleEggTester() }
    }

    @Test
    fun checkTesterPerformance() {
        val performance = performanceTestBench(100) { ExampleEggTester() }
        print("Total test count: $performance")
    }

}