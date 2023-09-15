def solution(my_string):
    set1 = set()
    answer = ''
    for i in range(0, len(my_string)):
        if my_string[i] not in set1:
            answer += my_string[i]
            set1.add(my_string[i])
    return answer
