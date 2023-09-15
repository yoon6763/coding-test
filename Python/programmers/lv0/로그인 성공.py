def solution(id_pw, db):
    ans = "fail"
    for user in db:
        if user[0] == id_pw[0] and user[1] == id_pw[1]:
            ans = "login"
            break
        elif user[0] == id_pw[0] and user[1] != id_pw[1]:
            ans = "wrong pw"
    return ans
