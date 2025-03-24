package baekjoon.bronze.b4

fun main() = repeat(readln().toInt()) {
    var sum = 0.0
    repeat(readln().toInt()) {
        var (name, count, price) = readln().split(" ")
        if (price.startsWith(".")) price = "0$price"
        sum += count.toInt() * price.toDouble()
    }

    sum = Math.round(sum * 100) / 100.0
    println(String.format("$%.2f", sum))
}