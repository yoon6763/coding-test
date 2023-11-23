package baekjoon.bronze.b1

fun main() {
    val (p, w) = readln().split(" ").map(String::toInt)
    val s = readln()
    var ans = 0
    val alphabet = HashMap<Char, Int>()
    for(i in 'A'..'C') alphabet[i] = 0
    for(i in 'D'..'F') alphabet[i] = 1
    for(i in 'G'..'I') alphabet[i] = 2
    for(i in 'J'..'L') alphabet[i] = 3
    for(i in 'M'..'O') alphabet[i] = 4
    for(i in 'P'..'S') alphabet[i] = 5
    for(i in 'T'..'V') alphabet[i] = 6
    for(i in 'W'..'Z') alphabet[i] = 7
    alphabet[' '] = 8

    for (i in s.indices) {
        if(i > 0 && alphabet[s[i]] == alphabet[s[i - 1]] && s[i] != ' ') ans += w
        when(s[i]) {
            in arrayOf('A', 'D', 'G', 'J', 'M', 'P', 'T', 'W', ' ') -> ans += p
            in arrayOf('B', 'E', 'H', 'K', 'N', 'Q', 'U', 'X') -> ans += p * 2
            in arrayOf('C', 'F', 'I', 'L', 'O', 'R', 'V', 'Y') -> ans += p * 3
            in arrayOf('S', 'Z') -> ans += p * 4
        }
    }
    println(ans)
}