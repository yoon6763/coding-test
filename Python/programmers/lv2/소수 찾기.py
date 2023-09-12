import itertools

def solution(numbers):
    num = list(map(int, numbers))
    answer = []
    arr = []
    #해당 리스트(num)으로 만들 수 있는 모든 경우의 수
    for i in range(1,len(numbers)+1):
        permutations = list(itertools.permutations(numbers,i))
        for k in permutations:
            temp = int(''.join(k))
            arr.append(temp)

    set_list = set(arr)
    arr2 = list(set_list)

    for i in arr2:
        print(i)
        if isPrime(i) :
            answer.append(i)

    return len(answer)

def isPrime(num):
    if num == 0 or num == 1:
        return False
    if num == 2 or num == 3:
        return True
    for i in range(2, num):
        if num % i == 0:
            return False
    return True