package goormlevel.lv1.`대소문자 바꾸기`

fun main(args: Array<String>) {
    readLine()
    println(readLine()!!.map { if (it.isUpperCase()) it.lowercaseChar() else it.uppercaseChar() }.joinToString(""))
}w