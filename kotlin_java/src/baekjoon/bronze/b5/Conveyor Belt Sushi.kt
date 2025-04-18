package baekjoon.bronze.b5

fun main() {
    val sc = java.util.Scanner(System.`in`)

    val r = sc.nextInt()
    val g = sc.nextInt()
    val b = sc.nextInt()
    val c = r * 3 + g * 4 + b * 5

    println(c)
    sc.close()
}