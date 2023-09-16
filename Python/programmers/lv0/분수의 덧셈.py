def solution(denum1, num1, denum2, num2):
    a = num1 * num2
    b = denum1 * num2 + denum2 * num1

    init = max(a, b)
    gcd = 1

    for num in range(init, 0, -1):
        if a % num == 0 and b % num == 0:
            gcd = num
            break

    return [b / gcd, a / gcd]