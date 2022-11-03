while True:
    try:
        line = input()

        if line == EOFError:
            break

        nmb = list(map(float, line.split(" ")))

        cnt = 0

        while nmb[2] > nmb[0]:
            nmb[0] += nmb[0] * nmb[1] / 100
            cnt += 1

        print(cnt)
    except:
        break
