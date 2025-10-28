package baekjoon.bronze.b2

import java.util.*

fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == 0) break

        val left = Stack<Char>()
        val right = Stack<Char>()

        repeat(n) {
            val (keyword, target) = readln().split(" ")
            when (keyword) {
                "INSERT" -> left.push(target[0])
                "LEFT" -> if (left.isNotEmpty()) right.push(left.pop())
                "RIGHT" -> if (right.isNotEmpty()) left.push(right.pop())
            }
        }

        println(buildString {
            left.forEach { append(it) }
            while (right.isNotEmpty()) append(right.pop())
        })
    }
}
