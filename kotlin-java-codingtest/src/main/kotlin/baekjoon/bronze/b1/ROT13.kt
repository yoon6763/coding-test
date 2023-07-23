package baekjoon.bronze.b1

fun main() {
    val s = readln()
    val sb = StringBuilder()
    for (c in s) {
        when (c) {
            in 'A'..'M' -> sb.append((c.toInt() + 13).toChar())
            in 'N'..'Z' -> sb.append((c.toInt() - 13).toChar())
            in 'a'..'m' -> sb.append((c.toInt() + 13).toChar())
            in 'n'..'z' -> sb.append((c.toInt() - 13).toChar())
            else -> sb.append(c)
        }
    }
    println(sb)
}