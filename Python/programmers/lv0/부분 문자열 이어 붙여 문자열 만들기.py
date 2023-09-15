def solution(my_strings, parts):
    answer = ''
    for i in range(0, len(my_strings)):
        answer += my_strings[i][parts[i][0]:parts[i][1] + 1]
    return answer
