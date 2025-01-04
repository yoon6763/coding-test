package baekjoon.bronze.b2

fun main() {
    readln()
    val arr = readln()
    val pattern = arrayOf("ABC", "BABC", "CCAABB")
    val scores = IntArray(3)
    for (i in arr.indices) {
        for (j in pattern.indices) {
            if (arr[i] == pattern[j][i % pattern[j].length]) {
                scores[j]++
            }
        }
    }

    val max = scores.max()
    println(max)
    println(arrayOf("Adrian", "Bruno", "Goran").filterIndexed { index, _ -> scores[index] == max }.joinToString("\n"))
}