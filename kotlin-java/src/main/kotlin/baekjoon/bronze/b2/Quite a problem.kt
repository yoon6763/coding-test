package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        try {
            sb.append(if ("problem" in readLine().lowercase()) "yes\n" else "no\n")
        } catch (e: Exception) {
            break
        }
    }
    print(sb)
}