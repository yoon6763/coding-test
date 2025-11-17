package programmers.lv0.머쓱이보다_키_큰_사람

fun solution(array: IntArray, height: Int): Int {
    return array.count{it>height}
}