package baekjoon.bronze.b2

fun main() {
    val map = hashMapOf(
        'A' to 2, 'B' to 2, 'C' to 2,
        'D' to 3, 'E' to 3, 'F' to 3,
        'G' to 4, 'H' to 4, 'I' to 4,
        'J' to 5, 'K' to 5, 'L' to 5,
        'M' to 6, 'N' to 6, 'O' to 6,
        'P' to 7, 'Q' to 7, 'R' to 7, 'S' to 7,
        'T' to 8, 'U' to 8, 'V' to 8,
        'W' to 9, 'X' to 9, 'Y' to 9, 'Z' to 9
    )

    repeat(readln().toInt()) {
        val sb = StringBuilder()
        readln().uppercase().forEach {
            sb.append(map[it])
        }
        println(if (sb.toString() == sb.reverse().toString()) "YES" else "NO")
    }
}