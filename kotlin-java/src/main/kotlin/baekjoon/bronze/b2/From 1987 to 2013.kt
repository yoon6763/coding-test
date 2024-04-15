package baekjoon.bronze.b2

fun main() {
    var n = readln().toInt()

    while (true) {
        n++
        if(n.toString().length == n.toString().toCharArray().toSet().size) {
            println(n)
            break
        }
    }
}