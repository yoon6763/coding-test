package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()

    repeat(n) {
        sb.append("G".repeat(n))
        sb.append("...".repeat(n))
        sb.append("\n")
    }
    repeat(n) {
        sb.append(".".repeat(n))
        sb.append("I".repeat(n))
        sb.append(".".repeat(n))
        sb.append("T".repeat(n))
        sb.append("\n")
    }
    repeat(n) {
        sb.append("..".repeat(n))
        sb.append("S".repeat(n))
        sb.append(".".repeat(n))
        sb.append("\n")
    }

    print(sb)
}