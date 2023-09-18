def solution(my_string, is_prefix)
    if my_string.start_with?(is_prefix)
        return 1
    else
        return 0
    end
end