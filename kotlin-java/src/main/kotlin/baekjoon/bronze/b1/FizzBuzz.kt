package baekjoon.bronze.b1

fun main() {
    var ans = 0
    for (i in 3 downTo 1) {
        val line = readln()
        if (line !in arrayOf("Fizz", "Buzz", "FizzBuzz")) ans = line.toInt() + i
    }

    when {
        ans % 3 == 0 && ans % 5 == 0 -> println("FizzBuzz")
        ans % 3 == 0 -> println("Fizz")
        ans % 5 == 0 -> println("Buzz")
        else -> println(ans)
    }
}
