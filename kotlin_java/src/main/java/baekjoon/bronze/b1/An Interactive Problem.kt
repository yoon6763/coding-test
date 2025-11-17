package baekjoon.bronze.b1

fun main() {

    var ans = 0
    var col = 1000

    for (i in 1..1000) {
        for (j in 1..col) {
            println("? $i $j")
            val input = readln()
            if (input == "ArrayIndexOutOfBoundsException") {
                col = j - 1
                break
            }

            ans = maxOf(ans, input.toInt())
        }
    }

    println("! $ans")
}