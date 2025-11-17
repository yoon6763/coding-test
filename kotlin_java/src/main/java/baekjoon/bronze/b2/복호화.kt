package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    val result = IntArray(26)

    readln().filter { it.isLetter() }.forEach {
        result[it.code - 'a'.code]++
    }

    val max = result.max()
    println(if (result.count { it == max } > 1) "?" else result.indexOf(max).let { 'a' + it })
}