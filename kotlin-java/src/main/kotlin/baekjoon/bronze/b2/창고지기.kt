package baekjoon.bronze.b2

import kotlin.math.abs

fun main() {
    val input = readln().toCharArray()
    val robot = input.indexOf('@')
    val box = input.indexOf('#')
    val target = input.indexOf('!')
    println(if ((box in (robot + 1)..<target) || (box in (target + 1)..<robot)) abs(box - robot) - 1 + abs(target - box) else -1)
}
