def solution(my_string, queries):
    for query in queries:
        (start, end) = query
        my_string = my_string[:start] + my_string[start:end+1][::-1] + my_string[end+1:]
    return my_string