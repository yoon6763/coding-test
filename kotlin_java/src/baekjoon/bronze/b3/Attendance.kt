package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val inputs = List(n) { readln() }
    var index = 0
    var absent = false
    while (index < n) {
        val name = inputs[index]
        if (index + 1 < n && inputs[index + 1] == "Present!") {
            index += 2
        } else {
            println(name)
            absent = true
            index++
        }
    }

    if (!absent) println("No Absences")
}