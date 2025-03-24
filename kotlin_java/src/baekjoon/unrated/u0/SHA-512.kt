package baekjoon.unrated.u0

import java.security.MessageDigest

fun main() {
    val input = readln()

    val md = MessageDigest.getInstance("SHA-512")
    md.update(input.toByteArray())

    val sb = StringBuilder()
    for (b in md.digest()) {
        sb.append(String.format("%02x", b))
    }

    println(sb)
}