def solution(n)
    ans = 0
    if n % 2 == 0
        for i in 2..n
            if i % 2 == 0
                ans += (i * i)
            end
        end
    else
        for i in 1..n
            if i % 2 == 1
                ans += i
            end
        end
    end
    return ans
end