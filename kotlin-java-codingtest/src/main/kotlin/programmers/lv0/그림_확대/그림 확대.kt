package programmers.lv0.그림_확대

fun solution(picture: Array<String>, k: Int): Array<String> {
    val answer = Array(picture.size * k) { Array(picture[0].length * k) { ' ' } }

    for (i in picture.indices) {
        for (j in picture[i].indices) {
            for (x in 0 until k) {
                for (y in 0 until k) {
                    answer[i * k + x][j * k + y] = picture[i][j]
                }
            }
        }
    }

    return answer.map { it.joinToString("") }.toTypedArray()
}