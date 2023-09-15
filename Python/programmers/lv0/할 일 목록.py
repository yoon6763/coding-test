def solution(todo_list, finished):
    return [todo_list[i] for i in range(len(todo_list)) if not finished[i]]
