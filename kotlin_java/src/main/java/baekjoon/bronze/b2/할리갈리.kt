package baekjoon.bronze.b2

import kotlin.system.exitProcess

fun main() {
    val map = mutableMapOf<String, Int>()

    repeat(readln().toInt()) {
        val input = readln().split(" ")
        val fruit = input[0]
        val capacity = input[1].toInt()
        map[fruit] = map.getOrDefault(fruit, 0) + capacity
    }

    map.forEach { (t, u) ->
        if(u == 5) {
            println("YES")
            exitProcess(0)
        }
    }

    println("NO")
}
