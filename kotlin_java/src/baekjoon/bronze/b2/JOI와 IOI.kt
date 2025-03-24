package baekjoon.bronze.b2

fun main() {
    val line = readln()
    var joi = 0
    var ioi = 0

    for (i in 0 until line.length - 2) {
        if (line[i] == 'J') if (line[i + 1] == 'O' && line[i + 2] == 'I') joi++
        if (line[i] == 'I') if (line[i + 1] == 'O' && line[i + 2] == 'I') ioi++
    }
    println(joi)
    println(ioi)
}