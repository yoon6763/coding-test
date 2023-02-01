package baekjoon.bronze.b4

fun main() {
    repeat(readln().toInt()) {
        var (population, time) = readln().split(" ").map { it.toInt() }
        population += (time / 4)
        population -= (time / 7)

        println(population)
    }
}