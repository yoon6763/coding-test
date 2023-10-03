package programmers.lv1.카드_뭉치

fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
    var answer = "Yes"
    var cards1Idx = 0
    var cards2Idx = 0
    var goalIdx = 0

    while (goalIdx < goal.size) {
        if (cards1Idx < cards1.size && cards1[cards1Idx] == goal[goalIdx]) {
            cards1Idx++
            goalIdx++
        } else if (cards2Idx < cards2.size && cards2[cards2Idx] == goal[goalIdx]) {
            cards2Idx++
            goalIdx++
        } else {
            answer = "No"
            break
        }
    }

    return answer
}