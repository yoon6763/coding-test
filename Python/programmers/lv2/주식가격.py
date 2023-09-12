def solution(prices):
    arr = [ 0 for i in range(len(prices))]

    for i in range(0,len(prices)):
        for j in range(i,len(prices)-1):
            if prices[i] <= prices[j]:
                arr[i] = arr[i] + 1
            else:
                break;
    return arr