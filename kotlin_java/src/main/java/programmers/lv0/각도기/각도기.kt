package programmers.lv0.각도기

fun solution(angle: Int): Int {
    return when(angle) {
        in 0 until 90 -> 1
        90 -> 2
        in 90 until 180 -> 3
        else -> 4
    }
}