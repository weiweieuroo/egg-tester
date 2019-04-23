package com.ltman.eggtest.tester

interface EggTesterInterface {

    fun getNextTestFloor(numberOfFloor: Int, numberOfEggAvailable: Int): Int?

    fun reportResult(testAtFloor: Int, eggBroken: Boolean)

    fun getEggTestResult(): Int
}