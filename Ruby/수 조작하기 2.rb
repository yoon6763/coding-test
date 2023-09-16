def solution(numLog)
    answer = ''
    pre = numLog[0]

    for i in 1..numLog.length-1
        gap = numLog[i] - pre

        if gap == 1
            answer += 'w'
        elsif gap == -1
            answer += 's'
        elsif gap == 10
            answer += 'd'
        elsif gap == -10
            answer += 'a'
        end

        pre = numLog[i]
    
    end

    return answer

end