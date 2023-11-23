package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val hash = HashMap<String, Int>()
    readLine().split(" ").forEach { hash[it] = 0 }
    repeat(n) {
        readLine().split(" ").forEach {
            hash[it] = hash[it]!! + 1
        }
    }
    val sb = StringBuilder()
    hash.toList().sortedWith(compareBy({ -it.second }, { it.first })).forEach {
        sb.append("${it.first} ${it.second}\n")
    }
    print(sb)
}