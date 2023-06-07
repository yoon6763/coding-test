package baekjoon.bronze.b1

fun main() = with(System.`in`.bufferedReader()) {
    val set = HashSet<String>()
    val n = readLine().toInt()

    for (i in 0 until n) {
        val line = readLine()
        if (line in set || line.reversed() in set) {
            println("${line.length} ${line[line.length / 2]}")
            break
        } else {
            set.add(line)
        }
    }
}