package programmers.lv3.`베스트앨범`

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList

class Music(val num: Int, val playedCount: Int)

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {

        val map = HashMap<String, ArrayList<Music>>()

        for (i in 0 until genres.size) {
            if (genres[i] !in map) {
                map[genres[i]] = ArrayList<Music>()
            }

            map[genres[i]]!!.add(Music(i, plays[i]))
        }

        val list = map.toList().sortedBy { -it.second.sumOf { it.playedCount } }

        val answer = ArrayList<Int>()
        var index = 0
        list.forEach {
            it.second.sortWith(compareBy({ -it.playedCount }, { it.num }))
            for(i in 0 until minOf(2, it.second.size)) {
                answer.add(it.second[i].num)
            }
        }

        return answer.toIntArray()
    }
}