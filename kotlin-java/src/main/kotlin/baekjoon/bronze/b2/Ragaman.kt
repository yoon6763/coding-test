package baekjoon.bronze.b2

fun main() {
    val aCount = IntArray(26)
    val bCount = IntArray(26)

    readln().forEach { aCount[it - 'a']++ }
    var joker = 0
    readln().forEach { if (it == '*') joker++ else bCount[it - 'a']++ }

    for (i in 0..<26) {
        if (aCount[i] < bCount[i]) {
            println("N")
            return
        }
    }

    for (i in 0..<26) {
        if (aCount[i] > bCount[i]) {
            joker -= aCount[i] - bCount[i]

            if (joker < 0) {
                println("N")
                return
            }

            aCount[i] = bCount[i]
        }
    }

    println("A")
}