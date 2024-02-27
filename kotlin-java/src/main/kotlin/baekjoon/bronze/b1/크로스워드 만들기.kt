package baekjoon.bronze.b1

fun main() {
    val (str2, str1) = readln().split(" ")
    var (index1, index2) = 0 to 0

    outer@ for (i in str2.indices) {
        for (j in str1.indices) {
            if (str2[i] == str1[j]) {
                index1 = j
                index2 = i
                break@outer
            }
        }
    }

    val answer = Array(str1.length) { CharArray(str2.length) { '.' } }

    for (i in str1.indices) answer[i][index2] = str1[i]
    for (i in str2.indices) answer[index1][i] = str2[i]

    print(answer.joinToString("\n") { it.joinToString("") })
}