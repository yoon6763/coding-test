package baekjoon.silver.s5

fun main() {
    var pre = readln()

    if (pre.length == 1) {
        println(0)
        if (pre.toLong() % 3 == 0L) println("YES")
        else println("NO")
        return
    }

    for (i in 0..<10000000) {
        var sum = 0L
        for (j in pre.indices) {
            sum += pre[j].toString().toLong()
        }

        if (sum < 10) {
            println(i + 1)
            if (sum % 3 == 0L) println("YES")
            else println("NO")
            break
        }

        pre = sum.toString()
    }
}