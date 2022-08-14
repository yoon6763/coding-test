package baekjoon.bronze.b5

fun main() {
    print(fibo(readLine()!!.toInt()))
}

fun fibo(n: Int): Int {
    return if(n <= 1)
        n
    else
        fibo(n - 1) + fibo(n - 2)
}