package programmers.lv1.나머지가_1이_되는_수_찾기

fun solution(n: Int): Int {
    for(i in 1..n) {
        if(n % i == 1){
            return i
        }
    }
    return 0
}