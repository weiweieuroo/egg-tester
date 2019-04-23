package com.ltman.eggtest.tester

class ExampleEggTester: EggTesterInterface {

    private var lastTestFloor = -1
    private var foundResult = false

    override fun getNextTestFloor(numberOfFloor: Int, numberOfEggAvailable: Int): Int? {
        if (foundResult) return null
        lastTestFloor++
        return if (lastTestFloor <= numberOfFloor) {
            lastTestFloor
        } else {
            null
        }
    }

    override fun reportResult(testAtFloor: Int, eggBroken: Boolean) {
        foundResult = eggBroken
    }

    override fun getEggTestResult(): Int {
        return lastTestFloor
    }
}