package baekjoon.bronze.b1

fun main() {
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }
    var flag = false
    var suma = 0
    var sumb = 0

    for (i in a.indices) {
        suma += a[i]
        if (suma > sumb) {
            flag = true
            break
        }
        sumb += b[i]
    }
    println(if (flag) "Yes" else "No")
}