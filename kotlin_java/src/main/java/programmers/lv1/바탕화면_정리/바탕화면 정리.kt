package programmers.lv1.바탕화면_정리

fun solution(wallpaper: Array<String>): IntArray {
    var (x1, y1, x2, y2) = arrayOf(1, 1, 50, 50)

    for (i in wallpaper.indices) {
        for (j in wallpaper[i].indices) {
            if (wallpaper[i][j] == '#') {
                x1 = minOf(x1, i)
                y1 = minOf(y1, j)
                x2 = maxOf(x2, i)
                y2 = maxOf(y2, j)
            }
        }
    }

    return intArrayOf(x1, y1, x2+1, y2+1)
}