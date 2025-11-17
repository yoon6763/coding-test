package baekjoon.bronze.b2

var cnt = 0

fun recursion(s: String, l: Int, r: Int): Int {
    cnt++
    return if (l >= r) 1
    else if (s[l] != s[r]) 0
    else recursion(s, l + 1, r - 1)
}

fun isPalindrome(s: String): Int {
    return recursion(s, 0, s.length - 1)
}

fun main() {
    repeat(readln().toInt()) {
        cnt = 0
        println("${isPalindrome(readln())} $cnt")
    }
}