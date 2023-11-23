package baekjoon

fun main() {
    val input = readLine()!!.split(" ")
    val n1 = input[0].toInt()
    val n2 = input[1].toInt()

    if (n1 > n2) {
        LCM(n1, n2, GCD(n1, n2))
    } else {
        LCM(n2, n1, GCD(n2, n1))
    }
}

fun GCD(n1: Int, n2: Int): Int {
    return if (n2 == 0) {
        println(n1)
        n1
    } else {
        GCD(n2, n1 % n2)
    }
}

fun LCM(n1: Int, n2: Int, gcd: Int) {
    print(n1 * n2 / gcd)
}