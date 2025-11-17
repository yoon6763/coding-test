package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()
    val s = readln()
    val result = s.map { ch ->
        when (ch) {
            'J' -> 'O'
            'O' -> 'I'
            'I' -> 'J'
            else -> ch
        }
    }.joinToString("")
    println(result)
}