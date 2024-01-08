def solution(routes):
    pq = []
    for (s, e) in routes:
        pq.append((s, e))

    pq.sort(key=lambda x: x[1])

    answer = 0
    camera_pos = -987654321

    while pq:
        (s, e) = pq.pop(0)
        if s <= camera_pos <= e:
            continue
        answer += 1
        camera_pos = e

    return answer
