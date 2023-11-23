package programmers.lv2.카펫

fun solution(brown: Int, yellow: Int): IntArray {
    var v = 3
    var h = 3

    while(true) {
        val y = (v-2) * (h-2)
        val b = v * h - y

        if(brown == b && yellow == y) {
            return intArrayOf(h,v)
        }

        if(v * h > brown + yellow) {
            h = 2
            v++
        }
        h++
    }

}