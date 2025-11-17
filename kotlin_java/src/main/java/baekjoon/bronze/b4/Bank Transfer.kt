package baekjoon.bronze.b4


fun main() {
    val mny = (readln().toInt() * 0.01 + 25)

    print(
        when {
            mny < 100 -> 100
            2000 < mny -> 2000
            else -> mny
        }
    )
}
