f = open('baseball.txt',encoding='UTF8')
while (True):
    try:
        n = input('출력할 라인 수는?(q로 종료) : ')
        if n == 'q':
            break
        else:
            n = int(n)
            if (n <= 10 and n > 0):
                for i in range(n):
                    line = f.readline()
                    print(line.strip('\n'))
            else:
                raise Exception('입력 라인 수는 1~10까지 입니다.')

    except ValueError:
        print('입력은 정수로만 해주세요.')

    except Exception as err:
        print('예외가 발생했습니다.', err)