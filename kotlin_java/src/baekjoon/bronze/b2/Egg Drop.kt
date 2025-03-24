package baekjoon.bronze.b2

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var maxFloorEggNotBroken = 1
    var minFloorEggBroken = k
    repeat(n) {
        val (floor, isBroken) = readln().split(" ")
        if (isBroken == "BROKEN") minFloorEggBroken = minOf(minFloorEggBroken, floor.toInt()) else maxFloorEggNotBroken = maxOf(maxFloorEggNotBroken, floor.toInt())
    }
    println("${maxFloorEggNotBroken + 1} ${minFloorEggBroken - 1}")
}