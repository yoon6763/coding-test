package baekjoon.gold.g5.`계란으로 계란치기`

data class Egg(var hp: Int, var weight: Int)

lateinit var eggs: Array<Egg>
var max = 0
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    eggs = Array(n) {
        val (hp, weight) = readLine().split(" ").map { it.toInt() }
        Egg(hp, weight)
    }

    backTracking(0)
    println(max)
}

fun backTracking(curIdx: Int) {
    if (n == curIdx) {
        max = max.coerceAtLeast(eggs.count { it.hp <= 0 })
        return
    }

    if (eggs[curIdx].hp <= 0) {
        backTracking(curIdx + 1)
        return
    }

    var isEggBroken = false

    for (otherEggIdx in 0 until n) {
        if (eggs[otherEggIdx].hp <= 0 || otherEggIdx == curIdx) continue
        isEggBroken = true
        eggs[otherEggIdx].hp -= eggs[curIdx].weight
        eggs[curIdx].hp -= eggs[otherEggIdx].weight
        backTracking(curIdx + 1)
        eggs[otherEggIdx].hp += eggs[curIdx].weight
        eggs[curIdx].hp += eggs[otherEggIdx].weight
    }

    if (!isEggBroken) backTracking(curIdx + 1)
}