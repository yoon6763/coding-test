package baekjoon.bronze.b1

fun main() {
    val case = readLine()!!.toInt()
    var arr = Array(case) { "" }
    var result = ""
    for (i in 0 until case)
        arr[i] = readLine()!!

    for (i in 0 until arr[0].length) {
        var isDiff = false
        val word = arr[0][i]

        for (j in 1 until case) {
            if (arr[j][i] != word) {
                isDiff = true
                break
            }
        }

        result +=
            if (isDiff)
                "?"
            else
                word

    }

    print(result)
}