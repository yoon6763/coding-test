package goormlevel.lv2.`카드 모으기`

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val set = HashSet<String>()

    repeat(m) {
        set.add(readLine()!!)
        if (set.size == n) {
            println(it + 1)
            return
        }
    }
    println(-1)
}