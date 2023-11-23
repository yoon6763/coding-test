package baekjoon.silver.s4

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val isPrime = Array(n + 1) { true }

    var cnt = 0
    var idx = 2

    while (idx <= n) {
        // 이미 소수가 아니라고 확인했으면 다음 idx로 넘어감
        while (!isPrime[idx]) {
            idx++
        }

        var multi = 1

        while (idx * multi <= n) {
            // 이미 소수가 아니라고 확인했으면 다음 multi 값으로 넘어감
            // 에라토스테네스의 채를 활용하는 경우에는 불필요하나, 몇 번째로 지워지는지 확인하기 위해 추가됨
            if (!isPrime[idx * multi]) {
                multi++
                continue
            }

            isPrime[idx * multi] = false
            cnt++

            // k번째로 지워진 수 이면
            if (cnt == k) {
                println(idx * multi)
                return
            }
            multi++
        }

        idx++
    }
}
