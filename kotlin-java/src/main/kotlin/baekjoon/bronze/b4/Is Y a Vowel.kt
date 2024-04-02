package baekjoon.bronze.b4

fun main() {
    val t1 = arrayOf('a', 'e', 'i', 'o', 'u')
    val t2 = arrayOf('a', 'e', 'i', 'o', 'u', 'y')
    var ans1 = 0
    var ans2 = 0
    readln().forEach {
        if (it in t1) ans1++
        if (it in t2) ans2++
    }
    println("$ans1 $ans2")
}