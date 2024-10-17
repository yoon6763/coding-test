input()
result = ""
for i in input().rstrip():
    if i == "I":
        result += "i"
    else:
        result += "L"
print(result)