package baekjoon.bronze.b2

fun main() {
    val sb = StringBuilder()
    var cnt = 1
    while (true) {
        val input = readln().split(" ")
        if (input[1] == "E") break
        val a = input[0].toInt()
        val b = input[2].toInt()

        sb.append("Case $cnt: ")
        when (input[1]) {
            ">" -> sb.append(a > b)
            ">=" -> sb.append(a >= b)
            "<" -> sb.append(a < b)
            "<=" -> sb.append(a <= b)
            "==" -> sb.append(a == b)
            "!=" -> sb.append(a != b)
        }
        sb.append("\n")
        cnt++
    }

    print(sb)
}