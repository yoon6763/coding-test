package baekjoon.bronze.b4

fun main() {
    val sb = StringBuilder()
    while (true) {
        val name = readlnOrNull() ?: break
        name.forEach {
            sb.append(
                when (it) {
                    'I' -> "E"
                    'E' -> "I"
                    'i' -> "e"
                    'e' -> "i"
                    else -> it
                }
            )
        }
        sb.append("\n")
    }
    print(sb)
}