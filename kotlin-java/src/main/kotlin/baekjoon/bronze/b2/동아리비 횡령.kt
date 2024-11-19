package baekjoon.bronze.b2

fun main() {
    val arr = readln().split("+")
    print(if (!arr.any { it.isEmpty() } && arr.size == 2 && !arr.any { !it.all(Char::isDigit) } && !arr.any { it.startsWith("0") } && arr[0] == arr[1]) "CUTE" else "No Money")
}
