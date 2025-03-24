package baekjoon.bronze.b4

fun main() {
    repeat(readln().toInt()) {
        val (stnum, s, itm, tech) = readln().split(" ").map { it.toDouble() }
        if (s + itm + tech >= 55 &&
            s / 35 >= 0.3 &&
            itm / 25 >= 0.3 &&
            tech / 40 >= 0.3
        ) {
            println("${stnum.toInt()} ${(s + itm + tech).toInt()} PASS")
        } else {
            println("${stnum.toInt()} ${(s + itm + tech).toInt()} FAIL")
        }
    }
}