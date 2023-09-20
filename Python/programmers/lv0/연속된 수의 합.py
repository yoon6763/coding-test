def solution(num, total):
    arr = [i for i in range(1, num + 1)]

    while sum(arr) != total:
        if sum(arr) > total:
            for i in range(0, num):
                arr[i] -= 1
        else:
            for i in range(0, num):
                arr[i] += 1

    return arr
