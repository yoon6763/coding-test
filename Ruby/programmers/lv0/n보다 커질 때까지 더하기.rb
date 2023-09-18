def solution(numbers, n)
    answer = 0
    numbers.each do |number|
        if answer <= n
            answer += number
        end
    end

    return answer
end