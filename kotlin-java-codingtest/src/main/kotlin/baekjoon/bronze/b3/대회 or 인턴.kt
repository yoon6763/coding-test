package baekjoon.bronze.b3

fun main() {
    var (boy, girl, intern) = readln().split(" ").map { it.toInt() }
    var team = minOf(boy / 2, girl)
    intern -= (boy - team * 2 + girl - team)

    while (intern > 0) {
        team--
        intern -= 3
    }

    println(maxOf(0, team))
}