package baekjoon.bronze.b2

fun main() {
    val str1 = readln()
    val str2 = readln()
    val sb = StringBuilder()

    for (i in str1.indices) {
        // a & b
        if (str1[i] == '1' && str2[i] == '1') sb.append("1") else sb.append("0")
    }
    sb.append("\n")
    for (i in str1.indices) {
        // a | b
        if (str1[i] == '1' || str2[i] == '1') sb.append("1") else sb.append("0")
    }
    sb.append("\n")
    for (i in str1.indices) {
        // a ^ b
        if (str1[i] != str2[i]) sb.append("1") else sb.append("0")
    }
    sb.append("\n")
    for (i in str1.indices) {
        // ~a
        if (str1[i] == '1') sb.append("0") else sb.append("1")
    }
    sb.append("\n")
    for (i in str1.indices) {
        // ~b
        if (str2[i] == '1') sb.append("0") else sb.append("1")
    }
    println(sb)
}