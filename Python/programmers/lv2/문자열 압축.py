def solution(s):
    min = len(s)

    for i in range(1, int(len(s) / 2)+1):
        stack1 = []
        stack2 = []
        ptr = 0
        rest = 0

        for k in range(0, int(len(s) / i)):
            rest = k*i+i
            tempstr = s[k*i : k*i+i]

            if len(stack1) == 0:
                stack1.append(tempstr)
                stack2.append(1)
                ptr = 1
            else:
                if stack1[ptr-1] == tempstr:
                    stack2[ptr-1] = stack2[ptr-1] + 1
                else:
                    stack1.append(tempstr)
                    stack2.append(1)
                    ptr = ptr + 1

        stack1.append(s[rest:])

        sum_len = sum([ len(k) for k in stack1])
        sum_len = sum_len + sum([len(str(k)) for k in stack2 if k != 1])

        if sum_len < min:
            min = sum_len
        print(stack1)
        print(stack2)
    return min