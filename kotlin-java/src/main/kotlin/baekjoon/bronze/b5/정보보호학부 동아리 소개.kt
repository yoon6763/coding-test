package baekjoon.bronze.b5

fun main() {
    print(when(readln()) {
        "M" -> "MatKor"
        "W" -> "WiCys"
        "C" -> "CyKor"
        "A" -> "AlKor"
        else -> "\$clear"
    })
}