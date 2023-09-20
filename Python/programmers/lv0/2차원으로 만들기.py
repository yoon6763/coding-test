def solution(num_list, n):
    answer = []
    tempList = []
    for i in range(len(num_list)):
        tempList.append(num_list[i])
        if (i + 1) % n == 0:
            answer.append(tempList)
            tempList = []

    return answer
