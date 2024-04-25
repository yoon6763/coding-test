package baekjoon.bronze.b3

fun main() {
    var (a, b) = 0 to 0
    for (i in 1..9) {
        println("? A $i")
        if (readln() == "1") {
            a = i
            break
        }
    }
    for (i in 1..9) {
        println("? B $i")
        if (readln() == "1") {
            b = i
            break
        }
    }

    println("! ${a + b}")
}