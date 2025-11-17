package programmers.lv0.짝수는_싫어요

fun solution(n: Int): IntArray {
    val list = ArrayList<Int>()

    for(i in 1 .. n) {
        if(i % 2 == 1) list.add(i)
    }

    return list.toIntArray()
}