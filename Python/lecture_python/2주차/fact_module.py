def fact(target):
    n = 1
    for i in range(2, target + 1):
        n *= i
    return n


if __name__ == '__main__':
    print(fact(5))
