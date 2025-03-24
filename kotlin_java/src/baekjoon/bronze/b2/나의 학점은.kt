package baekjoon.bronze.b2

fun main() = print(when (readln().split(" ").map { it.toInt() }.indexOf(readln().toInt())) {
        in 0..4 -> "A+"
        in 5..14 -> "A0"
        in 15..29 -> "B+"
        in 30..34 -> "B0"
        in 35..44 -> "C+"
        in 45..47 -> "C0"
        else -> "F" })
