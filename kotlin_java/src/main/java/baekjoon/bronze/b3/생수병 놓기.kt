package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val mline = readln()
    val eline = readln()

    val m = mline.count { it == 'w' }
    val e = eline.count { it == 'w' }

    when {
        e < m -> println("Oryang")
        e > m -> println("Manners maketh man")
        mline == eline -> println("Good")
        else -> println("Its fine")
    }
}