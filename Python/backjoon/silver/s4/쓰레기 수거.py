rept = int(input())

for i in range(rept):

    # 쓰레기차의 용량 w, 지점의 갯수 n
    max_weight, n = map(int, input().split(" "))

    weight = []
    distance = []

    for k in range(n):
        temp1, temp2 = map(int, input().split(" "))
        distance.append(temp1)
        weight.append(temp2)

    now_weight = 0
    now_distance = 0

    for k in range(n):
        #거리를 옴
        if k == 0:
            now_distance = distance[0]
        else:
            now_distance = now_distance + distance[k] - distance[k-1]


        #지금까지 실었던 무게 + 지금 실으려는 무게 > 최대 적재 가능 무게
        if now_weight + weight[k] > max_weight:
            #한번 비우고 옴
            now_distance = now_distance + distance[k] * 2
            now_weight = 0

            #비우고 와서 실었음
            now_weight = weight[k]

        #그냥 아무 문제 없이 쓰레기 실었음
        else:
            #현재 weight 증가함
            now_weight = now_weight + weight[k]

        #쓰레기 축적 작업이 끝난 후 지금 용량이 한계에 도달하면
        if now_weight == max_weight and k != n-1:
            now_distance = now_distance + distance[k] * 2
            now_weight = 0

    #돌아오는 길
    now_distance = now_distance + distance[-1]

    print(now_distance)
