package baekjoon.bronze.b2

fun main() {
    val arr = IntArray(26)
    repeat(readln().toInt()) {
        arr[readln()[0] - 'a']++
    }
    val sb = StringBuilder()
    arr.forEachIndexed { index, i ->
        if (i >= 5) sb.append("${'a' + index}")
    }
    println(sb.ifEmpty { "PREDAJA" })
}