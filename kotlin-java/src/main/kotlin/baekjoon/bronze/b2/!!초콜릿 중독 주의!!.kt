package baekjoon.bronze.b2

fun main() {
    repeat(readln().toInt()) {
        val line = readln()

        val numberIndex = line.indexOfFirst { it.isDigit() }
        val leftCount = line.substring(0, numberIndex).length
        val rightCount = line.substring(numberIndex).length - 1

        var num = line[numberIndex].toString().toInt()

        if (rightCount > 0) {
            num = 1
        }

        if (leftCount % 2 == 1) {
            num = if (num == 1) 0 else 1
        }

        println(num)
    }
}
