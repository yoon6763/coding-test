package baekjoon.bronze.b3

fun main() {
    readln().toInt()
    val durance = readln().split(" ").map { it.toInt() }.toIntArray()
    readln()
    readln().split(" ").map { it.toInt() - 1 }.forEach {
        durance[it]--
    }
    durance.forEach {
        if (it < 0) println("yes")
        else println("no")
    }
}