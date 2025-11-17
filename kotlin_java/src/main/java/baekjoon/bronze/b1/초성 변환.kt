package baekjoon.bronze.b1

fun main() {
    val name = readln()
    val choseong = "ㄱㄲㄴㄷㄸㄹㅁㅂㅃㅅㅆㅇㅈㅉㅊㅋㅌㅍㅎ"
    for (i in name.indices) {
        print(choseong[(name[i].toInt() - 44032) / 588])
    }
}
