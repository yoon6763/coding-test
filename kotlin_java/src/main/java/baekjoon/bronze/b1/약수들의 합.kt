package baekjoon.bronze.b1

fun main() {
    val sb = StringBuilder()
    while (true) {
        val n = readln().toInt()
        if (n == -1) break

        val list = ArrayList<Int>()
        var sum = 0
        for (i in 1 until n) {
            if (n % i == 0) {
                sum += i
                list.add(i)
            }
        }
        if (sum == n) sb.append("$n = ").append(list.joinToString(" + ")).append("\n")
        else sb.append("$n is NOT perfect.\n")
    }
    print(sb)
}