package baekjoon.bronze.b4

fun main() {
    val sb = StringBuilder()
    for (i in 1..readln().toInt()) {
        sb.appendLine(
            if (i % 7 == 0 && i % 11 != 0) {
                "Hurra!"
            } else if (i % 7 != 0 && i % 11 == 0) {
                "Super!"
            } else if (i % 7 == 0 && i % 11 == 0) {
                "Wiwat!"
            } else {
                i
            }
        )
    }
    print(sb)
}