package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val word = HashMap<String, String>()
    repeat(readLine().toInt()) {
        val (a, b) = readLine().split(" ")
        word[b] = a
    }

    val input = readLine()
    for (i in input.indices step 4) {
        print(word[input.substring(i, i + 4)] ?: "?")
    }
}