package baekjoon.silver.s3

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map(String::toInt)
    val sb = StringBuilder()
    val hash = HashMap<String, String>()

    repeat(n) {
        val groupName = readLine()
        repeat(readLine().toInt()) { hash[readLine()] = groupName }
    }

    repeat(m) {
        val content = readLine()
        if (readLine() == "0") hash.filter { it.value == content }.keys.sorted().forEach { sb.append(it).append("\n") }
        else sb.append(hash[content]).append("\n")
    }

    print(sb)
}