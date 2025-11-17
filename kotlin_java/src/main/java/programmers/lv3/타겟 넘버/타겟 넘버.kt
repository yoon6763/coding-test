package programmers.lv3.`타겟 넘버`

var cnt = 0

fun solution(numbers: IntArray, target: Int): Int {
    backTracking(numbers, target, 0, 0)

    return cnt
}

fun backTracking(num:IntArray, target:Int, idx:Int, sum:Int) {

    if(idx == num.size) {
        if(sum == target) cnt++

        return
    }

    backTracking(num, target, idx+1, sum+num[idx])
    backTracking(num, target, idx+1, sum-num[idx])

}