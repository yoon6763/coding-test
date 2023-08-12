package baekjoon.silver.s1

fun main() {
    val (l, r) = readln().split(" ")
    var ans = 0
    if(l.length == r.length) {
        for(i in l.indices) {
            if(l[i] != r[i]) break
            if(l[i] == '8') ans++
        }
    }
    println(ans)
}