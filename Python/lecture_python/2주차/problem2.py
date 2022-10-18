import calendar as cal

print("2022년은 윤년? " + str(cal.isleap(2022)))
print("2000~2050년 사이 윤년의 개수: " + str(len([i for i in range(2000, 2051) if cal.isleap(i)])))

week = "월화수목금토일"
print("2022년 10월 13일은: " + str(week[cal.weekday(2022, 10, 13)]) + "요일")