package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val arr = "0 ${readln()}".split(" ").map { it.toInt() }
    var cnt = 0

    for (i in 1..n)
        for (j in i..n)
            arr.slice(i..j).sum().let { if (it % (j - i + 1) == 0 && it / (j - i + 1) in arr.slice(i..j)) cnt++ }

    print(cnt)
}