package baekjoon.bronze.b2

fun main() = print(List(readln().toInt()){ readln().split(" ") }.sortedWith(compareBy({ -it[1].toInt() }, { it[0] }))[0][0])