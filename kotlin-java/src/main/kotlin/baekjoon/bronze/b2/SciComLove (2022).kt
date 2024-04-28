package baekjoon.bronze.b2

import java.util.*

fun main() {
    val str = LinkedList<Char>() as Queue<Char>
    str.addAll(arrayOf('S', 'c', 'i', 'C', 'o', 'm', 'L', 'o', 'v', 'e'))
    repeat(readln().toInt() % 10) {
        str.add(str.poll())
    }
    println(str.joinToString(""))
}