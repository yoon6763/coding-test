def solution(id_list, report, k):
    user_report_list = {user: set() for user in id_list}
    reported_user_list = {user: set() for user in id_list}

    for rep in report:
        (user, reported_user) = rep.split()
        user_report_list[user].add(reported_user)
        reported_user_list[reported_user].add(user)

    stopped_user_list = [id for id in id_list if len(reported_user_list[id]) >= k]

    ans = []
    for user in user_report_list:
        ans.append(sum([1 for user in user_report_list[user] if user in stopped_user_list]))

    return ans
