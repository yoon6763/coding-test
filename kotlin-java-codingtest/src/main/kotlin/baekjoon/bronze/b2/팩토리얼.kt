package baekjoon.bronze.b2

fun main() {
    val case = readLine()!!.toInt()

    for (i in 0 until case) {
        val target = readLine()!!.toInt()
        var number = 1
        for (k in 2..target) {
            number *= k
            while (number % 10 == 0) {
                number /= 10
            }
            number %= 100000
        }
        println(number%10)
    }
}
