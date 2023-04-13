package baekjoon.silver.s1

import kotlin.math.sqrt

fun main() {
    var n = readln().toInt()

    val isPrime = BooleanArray(1004002) { true }

    for(i in 2 ..sqrt(1004001.0).toInt()) {
        if(isPrime[i]) {
            for(j in i * 2 .. 1004001 step i) {
                isPrime[j] = false
            }
        }
    }
    isPrime[0] = false
    isPrime[1] = false

    while(true) {
        if(isPrime[n] && n.toString() == n.toString().reversed()) {
            println(n)
            break
        }
        n++
    }
}