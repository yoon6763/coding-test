def solution(num_list):
    if len(num_list) >= 11:
        return sum(num_list)
    else:
        ans = num_list[0]
        for i in range(1, len(num_list)):
            ans *= num_list[i]
        return ans
