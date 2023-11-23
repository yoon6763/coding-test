package baekjoon.bronze.b2

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val alphabet = BooleanArray(26)
        readln().uppercase().forEach { if (it in 'A'..'Z') alphabet[it - 'A'] = true }
        if (alphabet.all { it }) sb.append("pangram\n")
        else {
            sb.append("missing ")
            for (i in alphabet.indices) if (!alphabet[i]) sb.append('a' + i)
            sb.append("\n")
        }
    }
    print(sb)
}