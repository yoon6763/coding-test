def solution(s):
    stack = []
    ptr = 0
    for i in s:
        stack.append(i)
        while(True):
            if ptr >= 1 and stack[ptr] == stack[ptr-1]:
                stack.pop()
                stack.pop()
                ptr = ptr - 2
            else:
                ptr = ptr + 1
                break

    if len(stack) > 0:
        return 0
    else:
        return 1