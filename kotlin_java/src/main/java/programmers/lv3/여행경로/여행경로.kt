package programmers.lv3.여행경로

lateinit var visited: Array<Boolean>
lateinit var candiRoute: ArrayList<String>

fun solution(tickets: Array<Array<String>>): Array<String> {
    visited = Array(tickets.size) { false }
    candiRoute = ArrayList<String>()

    dfs(tickets, "ICN", 0, "ICN")

    candiRoute.sort()

    return candiRoute[0].split(" ").toTypedArray()
}

fun dfs(tickets:Array<Array<String>>, route:String, cnt: Int, currentCity: String) {

    if(tickets.size == cnt) {
        candiRoute.add(route)
        return
    }

    for(i in 0 until tickets.size) {
        if(!visited[i] && tickets[i][0] == currentCity) {
            visited[i] = true
            dfs(tickets, "${route} ${tickets[i][1]}", cnt + 1, tickets[i][1])
            visited[i] = false
        }
    }
}