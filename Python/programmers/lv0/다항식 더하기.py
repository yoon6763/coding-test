def solution(polynomial):
    polynomial = polynomial.split(" ")

    x = 0
    c = 0

    answer = []

    for p in polynomial:

        if p == '+':
            continue
        elif 'x' in p:
            if p == 'x':
                x += 1
            else:
                x += int(p[:-1])
        else:
            c += int(p)

    if x == 1:
        answer.append("x")
    elif x > 1:
        answer.append(str(x) + "x")

    if c > 0:
        answer.append(str(c))

    return " + ".join(answer)
