from queue import PriorityQueue


def solution(ability, number):
    pq = PriorityQueue()

    for abil in ability:
        pq.put(abil)

    for _ in range(number):
        sum = pq.get() + pq.get()
        pq.put(sum)
        pq.put(sum)

    ans = 0
    while not pq.empty():
        ans += pq.get()

    return ans
