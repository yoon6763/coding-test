package baekjoon.bronze.b4

fun main() {
    val optionOne = readln().toDouble()
    println("%.10f".format(100 / optionOne))
    println("%.10f".format(100 / (100 - optionOne)))
}
