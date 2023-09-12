def solution(s):
    temp = ("},"+s[1:-1]+",{").split("},{")[1:-1]
    arr = [ k.split(",") for k in temp]
    lens = [ len(i) for i in arr]
    answer = []

    for i in range(1,len(arr)+1):
        index = lens.index(i)
        ele = [ k for k in arr[index] if int(k) not in answer]
        answer.append(int(ele[0]))

    return answer