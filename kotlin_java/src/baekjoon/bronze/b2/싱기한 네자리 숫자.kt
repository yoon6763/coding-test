package baekjoon.bronze.b2

fun main() {
    val sb = StringBuilder()
    for (i in 2992..9999) {
        val sum10 = i.toString().sumOf { it - '0' }
        val sum12 = i.toString(12).sumOf { if(it in 'a'..'f') it - 'a' + 10 else it - '0' }
        val sum16 = i.toString(16).sumOf { if(it in 'a'..'f') it - 'a' + 10 else it - '0' }

        if (sum10 == sum12 && sum12 == sum16) {
            sb.appendLine(i)
        }
    }
    print(sb)
}
