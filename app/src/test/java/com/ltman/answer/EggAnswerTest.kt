package com.ltman.answer

import com.ltman.eggtest.BaseEggTesterTestBench
import com.ltman.eggtest.answer.EggAnswer
import org.junit.Test

class EggAnswerTest: BaseEggTesterTestBench() {

    @Test
    fun correctnessTest() {
        correctnessTestBench(100) { EggAnswer() }
    }

    @Test
    fun performanceTest() {
        val performance = performanceTestBench(100) { EggAnswer() }
        print("Total test count: $performance")
    }

}