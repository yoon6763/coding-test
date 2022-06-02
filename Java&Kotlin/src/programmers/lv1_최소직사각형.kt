package programmers

class lv1_최소직사각형 {
    fun main() {
        val array = arrayOf(intArrayOf(60, 50), intArrayOf(30, 70), intArrayOf(60, 30), intArrayOf(80, 40))
        solution(array)
    }

    fun solution(sizes: Array<IntArray>): Int {
        sizes.forEach { it.sort() }
        val s1 = sizes.maxOf { it[0] }
        val s2 = sizes.maxOf { it[1] }
        return s1 * s2
    }
}