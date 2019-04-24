package com.ltman.eggtest.answer


import com.ltman.eggtest.tester.EggTesterInterface

class EggAnswer: EggTesterInterface {
    var floor = -1
    var broken = 0
    var floorBroken = -1
    var rangeFloor = 10  //sqrt(100)
    var pastFloor = 0
    var firstBroken = true

    override fun getNextTestFloor(numberOfFloor: Int, numberOfEggAvailable: Int): Int? {
        if(broken>1) return null
        if(broken==1&&firstBroken){
            firstBroken = !firstBroken
            floor  = if (pastFloor<0) 0 else pastFloor
            return floor
        }
        pastFloor = floor
        floor += if(floor+rangeFloor>=100) 1 else rangeFloor

        return floor

    }

    override fun reportResult(testAtFloor: Int, eggBroken: Boolean) {
        if(eggBroken){
            floorBroken = testAtFloor
            if(++broken==1)
                rangeFloor = 1
            else broken++
        }

    }

    override fun getEggTestResult(): Int {
        return floorBroken
    }

}