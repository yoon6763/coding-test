package baekjoon.bronze.b5

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val (c, d) = readln().split(" ").map { it.toInt() }

    val hanyangTime = a + c
    val yongdapTime = b + d

    println(
        when {
            hanyangTime < yongdapTime -> "Hanyang Univ."
            hanyangTime > yongdapTime -> "Yongdap"
            else -> "Either"
        }
    )
}
