def solution(record):
    id = {}
    log = []

    for i in record:
        if i[0] == "E":
            temp = i.split(" ")

            if temp[1] in id:
                log.append(temp[1] + " E")
                id[temp[1]] = temp[2]
            else:
                log.append(temp[1]+" E")
                if temp[1] not in id:
                    id[temp[1]] = temp[2]
        elif i[0] == "L":
            temp = i.split(" ")
            log.append(temp[1] + " L")
        else:
            temp = i.split(" ")
            id[temp[1]] = temp[2]

    result_log = []
    for i in log:
        temp = i.split(" ")

        if temp[1] == "E":
            result_log.append(id[temp[0]]+ "님이 들어왔습니다.")
        else:
            result_log.append(id[temp[0]] + "님이 나갔습니다.")

    return result_log