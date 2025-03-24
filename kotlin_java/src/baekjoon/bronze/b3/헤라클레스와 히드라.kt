package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        var head = readln().toInt()
        readln().forEach { a -> head += if (a == 'c') 1 else -1 }
        println("Data Set ${it + 1}:\n$head\n")
    }
}
