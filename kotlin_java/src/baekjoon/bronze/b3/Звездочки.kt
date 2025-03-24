package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()

    for (i in 1..n) {
        val stars = i * i
        if (stars > 100) {
            repeat(100) { sb.append("*") }
            sb.append("...\n")
        } else {
            repeat(stars) { sb.append("*") }
            sb.append("\n")
        }
    }

    print(sb)
}