package baekjoon.silver.s2

fun main() = with(System.`in`.bufferedReader()) {
    val hash = HashMap<String, Int>()
    while (true) {
        val line = readLine() ?: break
        if(line.isEmpty()) break
        hash[line] = hash.getOrDefault(line, 0) + 1
    }
    val cnt = hash.values.sum()
    val sb = StringBuilder()

    hash.toList().sortedBy { it.first }.forEach {
        sb.append("${it.first} ${String.format("%.4f", it.second.toDouble() / cnt * 100)}\n")
    }

    println(sb)
}