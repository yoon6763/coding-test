package baekjoon.bronze.b1

fun main() = print((0..<readln().toInt()).flatMap {
    val (now, time) = readln().split(" ")
    val (h, m) = now.split(":").map { it.toInt() }
    var currentTime = h * 60 + m - 1

    (0..<time.toInt()).map {
        currentTime = (currentTime + 1) % 1440
        if (currentTime in 420..<1140) 10 else 5
    }
}.sum())