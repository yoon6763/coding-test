def solution(a, b, c, d):
    arr = sorted([a, b, c, d])

    if arr[0] == arr[1] == arr[2] == arr[3]:
        return 1111 * arr[0]
    if arr[0] == arr[1] == arr[2] != arr[3]:
        return (10 * arr[0] + arr[3]) ** 2
    if arr[0] != arr[1] == arr[2] == arr[3]:
        return (10 * arr[3] + arr[0]) ** 2
    if arr[0] == arr[1] != arr[2] == arr[3]:
        return (arr[0] + arr[3]) * abs(arr[0] - arr[3])
    if arr[0] == arr[1] and arr[1] != arr[2] != arr[3]:
        return arr[2] * arr[3]
    if arr[0] != arr[1] == arr[2] and arr[2] != arr[3]:
        return arr[0] * arr[3]
    if arr[0] != arr[1] != arr[2] == arr[3]:
        return arr[0] * arr[1]
    return arr[0]
