def solution(arr, idx)
    answer = -1
    for i in 0..arr.length-1
      if i >= idx && arr[i] == 1
        answer = i
        break
      end
    end
    return answer
  end