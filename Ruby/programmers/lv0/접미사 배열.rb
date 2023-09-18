def solution(my_string)
    answer = Array.new(my_string.length)
    idx = 0
  
    (my_string.length - 1).downto(0) do |i|
      answer[idx] = my_string[i..-1]
      idx += 1
    end
  
    answer.sort
  end
  