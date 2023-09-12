def solution(s):
    rm = 0
    cnt = 0
    saveds = s;

    while(s != "1"):
        s = s.replace("0","")
        rm = rm + len(saveds) - len(s)
        cnt = cnt + 1
        s = bin(int(len(s)))[2:]
        saveds = s
        print(rm)
    return [cnt,rm]