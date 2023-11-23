package baekjoon.bronze.b2

import java.lang.Math.pow

fun main() {
    val color = arrayOf("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white")
    println((color.indexOf(readLine()!!) * 10 + color.indexOf(readLine()!!)) * pow(10.0, color.indexOf(readLine()!!).toDouble()).toLong())
}