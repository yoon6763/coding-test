package baekjoon.bronze.b3

fun main() {
    var pre = ""

    while (true) {
        val s = readln()
        if (s == "99999") break

        val sum = (s[0] - '0') + (s[1] - '0')

        val dir = when {
            sum == 0 -> pre
            sum % 2 == 0 -> "right"
            else -> "left"
        }

        pre = dir
        println("$dir ${s.substring(2)}")
    }
}