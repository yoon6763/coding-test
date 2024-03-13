package baekjoon.bronze.b1

fun main() {
    val string = readln()
    var answer = 1
    for (i in string.indices) {
        var c = if (string[i] == 'c') 26 else 10
        if (i > 0 && string[i] == string[i - 1]) {
            c--
        }
        answer *= c
    }
    println(answer)
}
