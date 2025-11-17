package baekjoon.silver.s4

data class GuitarString(val packagePrice: Int, val price: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val guitarStrings = Array(m) {
        val line = readLine().split(" ").map { it.toInt() }
        GuitarString(line[0], line[1])
    }

    val lowestPackagePrice = guitarStrings.minOf { it.packagePrice }
    val lowestStringPrice = guitarStrings.minOf { it.price }

    val numberOfPackage = n / 6
    val numberOfString = n % 6

    var sum = 0

    if (lowestPackagePrice > lowestStringPrice * 6) {
        sum = lowestStringPrice * n
    } else {
        sum = numberOfPackage * lowestPackagePrice
        if (numberOfString >= 1) sum += minOf(numberOfString * lowestStringPrice, lowestPackagePrice)
    }
    println(sum)
}