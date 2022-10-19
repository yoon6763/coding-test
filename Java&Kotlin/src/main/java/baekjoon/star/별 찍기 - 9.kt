package baekjoon.star

fun main() {
    val layer = readLine()!!.toInt()
    val sb = StringBuilder()
    for (i in layer - 1 downTo 1) {
        repeat(layer - 1 - i) {
            sb.append(" ")
        }
        repeat(i * 2 + 1) {
            sb.append("*")
        }
        sb.append("\n")
    }

    repeat(layer) { it ->
        repeat(layer - it - 1) { it2 ->
            sb.append(" ")
        }
        repeat(1 + (it) * 2) { it2 ->
            sb.append("*")
        }
        sb.append("\n")
    }
    print(sb)
}