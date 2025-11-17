package programmers.lv0.문자열_계산하기

fun solution(my_string: String): Int {
    val str = my_string.split(" ")
    var ans = str[0].toInt()
    for (i in 1 until str.size step 2) {
        when (str[i]) {
            "+" -> ans += str[i + 1].toInt()
            "-" -> ans -= str[i + 1].toInt()
            else -> ans *= str[i + 1].toInt()
        }
    }
    return ans
}