def solution(str1, str2)
    answer = ''
    
    for i in 0..str1.length-1
        answer += str1[i]
        answer += str2[i]
    end

    return answer
end