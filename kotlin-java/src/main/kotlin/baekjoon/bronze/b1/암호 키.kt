package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val isPrime = BooleanArray(1000001) { true }

    for (i in 2..1000000) {
        if (isPrime[i]) {
            for (j in i * 2..1000000 step i) {
                isPrime[j] = false
            }
        }
    }

    repeat(n) {
        val m = readln().toLong()
        var flag = true
        for (j in 2..1000000) {
            if (m % j == 0L) {
                flag = false
                break
            }
        }
        println(if (flag) "YES" else "NO")
    }
}
