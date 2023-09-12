def solution(progresses, speeds):
    ptr = 0
    ptrs = 0
    answer = []
    while(ptr < len(progresses)):
        for k in range(len(progresses)):
            progresses[k] = progresses[k] + speeds[k]
            if progresses[k] > 100 : progresses[k] = 100

        if progresses[ptr] == 100:
            while(ptr < len(progresses)):
                if progresses[ptr] != 100:
                    break
                ptr = ptr + 1
            answer.append(ptr - ptrs)
            ptrs = ptr
    return answer