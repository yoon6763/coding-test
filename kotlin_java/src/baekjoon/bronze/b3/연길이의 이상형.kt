package baekjoon.bronze.b3

fun main() {
    val mbti = readln()
    val result = StringBuilder()
    for (i in mbti.indices) {
        when (mbti[i]) {
            'E' -> result.append('I')
            'I' -> result.append('E')
            'S' -> result.append('N')
            'N' -> result.append('S')
            'T' -> result.append('F')
            'F' -> result.append('T')
            'J' -> result.append('P')
            'P' -> result.append('J')
        }
    }
    println(result)
}