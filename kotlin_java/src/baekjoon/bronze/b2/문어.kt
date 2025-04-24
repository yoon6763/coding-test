package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()

    for (i in 0..<if (n % 2 == 1) n - 1 else n) {
        print(if (i % 2 == 1) "2 " else "1 ")
    }

    if (n % 2 == 1) {
        print("3")
    }
}
