def solution(number, k):
    stack = [number[0]]

    for i in range(1, len(number)):
        while len(stack) > 0 and stack[-1] < number[i] and k > 0:
            k -= 1
            stack.pop()
        stack.append(number[i])

    if k != 0:
        stack = stack[:-k]

    return ''.join(stack)
