def solution(A, B):
    answer = 0

    for i in range(len(A)):
        print(A)
        if A == B:
            return answer
        answer += 1
        A = A[-1] + A[:-1]

    return -1
