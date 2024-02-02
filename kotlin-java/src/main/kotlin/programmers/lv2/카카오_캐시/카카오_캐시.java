package programmers.lv2.카카오_캐시;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class 카카오_캐시 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int cacheSize = 4;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        System.out.println(solution.solution(cacheSize, cities));
    }
}

class Solution {

    class CacheData implements Comparable<CacheData> {
        String city;
        int time;

        public CacheData(String city, int time) {
            this.city = city;
            this.time = time;
        }

        @Override
        public int compareTo(CacheData o) {
            return this.time - o.time;
        }
    }

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;
        PriorityQueue<CacheData> cacheQueue = new PriorityQueue<>();
        HashSet<String> citiesInCache = new HashSet<>();
        HashMap<String, CacheData> cityCacheDataMap = new HashMap<>();

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();

            if (citiesInCache.contains(cities[i])) {
                // 캐시에 이미 있는 도시
                answer += 1;
                cacheQueue.remove(cityCacheDataMap.get(cities[i]));
                CacheData cacheData = new CacheData(cities[i], i);
                cacheQueue.offer(cacheData);
                cityCacheDataMap.put(cities[i], cacheData);
            } else {
                answer += 5;
                if (citiesInCache.size() >= cacheSize) {
                    // 캐시가 꽉 참
                    CacheData removedCity = cacheQueue.poll();
                    citiesInCache.remove(removedCity.city);
                    cityCacheDataMap.remove(removedCity.city);
                }

                citiesInCache.add(cities[i]);
                CacheData cacheData = new CacheData(cities[i], i);
                cityCacheDataMap.put(cities[i], cacheData);
                cacheQueue.offer(cacheData);
            }
        }

        return answer;
    }
}
