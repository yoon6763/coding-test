package programmers.lv1.최소직사각형

fun solution(sizes: Array<IntArray>): Int {
    sizes.forEach { it.sort() }
    val s1 = sizes.maxOf { it[0] }
    val s2 = sizes.maxOf { it[1] }
    return s1 * s2
}