def solution(binomial)
    str = binomial.split(" ")
    n1 = str[0].to_i
    n2 = str[2].to_i
    oper = str[1]

    if oper == '+'
        return n1 + n2
    elsif oper == '-'
        return n1 - n2
    elsif oper == '*'
        return n1 * n2
    elsif oper == '/'
        return n1 / n2
    end
end