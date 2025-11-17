package baekjoon.silver.s4

fun main() {
    var (n, kim, im) = readln().split(" ").map { it.toInt() }
    var round = 0

    while (kim != im) {
        round++
        kim -= kim / 2
        im -= im / 2
    }
    println(round)
}