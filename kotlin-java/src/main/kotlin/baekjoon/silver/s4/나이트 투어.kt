package baekjoon.silver.s4

import kotlin.math.abs
import kotlin.system.exitProcess

fun main() = with(System.`in`.bufferedReader()) {

    val initialInput = readLine()
    val ix = initialInput[0] - 'A'
    val iy = initialInput[1].digitToInt() - 1
    var oldX = ix
    var oldY = iy

    val visited = Array(6) { BooleanArray(6) }
    visited[ix][iy] = true

    repeat(35) {
        val newInput = readLine()
        val nx = newInput[0] - 'A'
        val ny = newInput[1].digitToInt() - 1

        if (visited[nx][ny]) exit()
        visited[nx][ny] = true

        val dx = abs(oldX - nx)
        val dy = abs(oldY - ny)
        if (!(dx == 2 && dy == 1 || dx == 1 && dy == 2)) exit()

        oldX = nx
        oldY = ny
    }

    val dx = abs(ix - oldX)
    val dy = abs(iy - oldY)
    if (!(dx == 2 && dy == 1 || dx == 1 && dy == 2) || visited.sumOf { it.count { !it } } > 0) exit()

    println("Valid")
}

fun exit() {
    println("Invalid")
    exitProcess(0)
}