def solution(num_list):
    odd = ''
    even = ''
    for i in range(len(num_list)):
        if num_list[i] % 2 == 0:
            even += str(num_list[i])
        else:
            odd += str(num_list[i])
    return int(even) + int(odd)