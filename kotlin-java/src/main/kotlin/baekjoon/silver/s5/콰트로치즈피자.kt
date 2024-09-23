package baekjoon.silver.s5

fun main() {
    readln()
    print(if (readln().split(" ").toSet().count { it.endsWith("Cheese") } > 3) "yummy" else "sad")
}