package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val str = readLine()
        if (str == "end") break
        var flag = true // 모음이 연속되었는지 확인하는 플래그
        val vowel = arrayOf('a', 'e', 'i', 'o', 'u')

        var vowelFlag = false // 모음이 있는지 확인하는 플래그

        for (i in str.indices) {
            if (str[i] in vowel) vowelFlag = true

            if (i < str.length - 2 && str[i] in vowel && str[i + 1] in vowel && str[i + 2] in vowel) {
                flag = false
                break
            }
            if (i < str.length - 2 && str[i] !in vowel && str[i + 1] !in vowel && str[i + 2] !in vowel) {
                flag = false
                break
            }
            if (i < str.length - 1 && str[i] !in arrayOf('e', 'o') && str[i] == str[i + 1]) {
                flag = false
                break
            }
        }

        if (flag && vowelFlag) sb.append("<$str> is acceptable.\n")
        else sb.append("<$str> is not acceptable.\n")
    }

    print(sb)
}