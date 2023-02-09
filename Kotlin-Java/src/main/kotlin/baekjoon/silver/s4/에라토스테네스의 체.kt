package baekjoon.silver.s4

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val isPrimes = Array(n + 1) { true }

    var cnt = 0
    var answer = 0

    for (i in 2..n) {
        if (!isPrimes[i]) continue

        var finish = false

        cnt++
        var multi = 2

        while (i * multi <= n) {
            if(!isPrimes[i*multi]) {
                multi++
                continue
            }
            println(i * multi)

            isPrimes[i * multi] = false
            cnt++

            if (cnt == k) {
                finish = true
                answer = i * multi
                break
            }

            multi++
        }
        if (finish) break
    }

    println(answer)
}