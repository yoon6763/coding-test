package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    var usedBatteryCapacity = 0
    var batteryCapacity = 0
    var prePhoneNumber = -1

    val connectedPhoneSequence = readln().split(" ").map { it.toInt() }

    for (i in 0..<n) {
        if (prePhoneNumber == connectedPhoneSequence[i]) {
            usedBatteryCapacity *= 2
            batteryCapacity += usedBatteryCapacity
        } else {
            prePhoneNumber = connectedPhoneSequence[i]
            usedBatteryCapacity = 2
            batteryCapacity += usedBatteryCapacity
        }
        if (batteryCapacity >= 100) {
            prePhoneNumber = 0
            usedBatteryCapacity = 0
            batteryCapacity = 0
        }
    }
    println(batteryCapacity)
}
