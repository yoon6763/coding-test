package baekjoon.bronze.b5

fun main() {
    println(
        when (readln()[0]) {
            'F' -> "Foundation"
            'C' -> "Claves"
            'V' -> "Veritas"
            'E' -> "Exploration"
            else -> ""
        }
    )
}
