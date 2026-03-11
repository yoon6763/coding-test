package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        val s = readln()

        val ab = s.substring(0, 2).toInt()
        val cd = s.substring(2, 4).toInt()

        if ((ab * ab + cd * cd) % 7 == 1) {
            println("YES")
        } else {
            println("NO")
        }
    }
}