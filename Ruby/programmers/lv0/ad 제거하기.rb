def solution(strArr)
    strArr.select { |a| !a.include?('ad') }
  end
  