package baekjoon.silver.s3

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val isPrime = BooleanArray(100001) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..<isPrime.size) {
        if (isPrime[i]) {
            for (j in i * 2..<isPrime.size step i) {
                isPrime[j] = false
            }
        }
    }

    repeat(readLine().toInt()) {
        var n = readLine().toInt()
        val map = HashMap<Int, Int>()
        var index = 2

        while (n > 1) {
            if (isPrime[index]) {
                if (n % index == 0) {
                    n /= index
                    map[index] = map.getOrDefault(index, 0) + 1
                } else {
                    index++
                }
            } else {
                index++
            }
        }

        map.keys.sorted().forEach { key ->
            sb.appendLine("$key ${map[key]}")
        }
    }

    print(sb)
}