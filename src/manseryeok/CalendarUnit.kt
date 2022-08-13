package manseryek

import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.sin
import kotlin.math.truncate

fun main() {

}

val TRUE = 0
val FALSE = 0

val montharray = arrayOf(
    0, 21355, 42843, 64498, 86335, 108366, 130578, 152958,
    175471, 198077, 220728, 243370, 265955, 288432, 310767, 332928,
    354903, 376685, 398290, 419736, 441060, 462295, 483493, 504693, 525949
)
/* 입춘시점에서 24절기의 시점까지의 길이 - 분
    yearmin := 525948.75 ; - 실제 1년길이 (분)
    yearmini := 525949 ; - 근사치 (오차 3456년에 1일)

    solorlat : array[0..24] of smallint =
        (315,330,345,0,15,30,45,60,75,90,105,120,135,150,165,180,195,210,
        225,240,255,270,285,300,315);
*/

val monthst = arrayOf(
    "입춘", "우수", "경칩", "춘분", "청명", "곡우",
    "입하", "소만", "망종", "하지", "소서", "대서",
    "입추", "처서", "백로", "추분", "한로", "상강",
    "입동", "소설", "대설", "동지", "소한", "대한", "입춘"
)

val gan = arrayOf('甲', '乙', '丙', '丁', '戊', '己', '庚', '辛', '壬', '癸')
val ji = arrayOf('子', '丑', '寅', '卯', '辰', '巳', '午', '未', '申', '酉', '戌', '亥');
val ganji = arrayOf(
    "甲子", "乙丑", "丙寅", "丁卯", "戊辰",
    "己巳", "庚午", "辛未", "壬申", "癸酉",
    "甲戌", "乙亥", "丙子", "丁丑", "戊寅",

    "己卯", "庚辰", "辛巳", "壬午", "癸未",
    "甲申", "乙酉", "丙戌", "丁亥", "戊子",
    "己丑", "庚寅", "辛卯", "壬辰", "癸巳",

    "甲午", "乙未", "丙申", "丁酉", "戊戌",
    "己亥", "庚子", "辛丑", "壬寅", "癸卯",
    "甲辰", "乙巳", "丙午", "丁未", "戊申",

    "己酉", "庚戌", "辛亥", "壬子", "癸丑",
    "甲寅", "乙卯", "丙辰", "丁巳", "戊午",
    "己未", "庚申", "辛酉", "壬戌", "癸亥"
)

val weekday = arrayOf("일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일")


val s28day = arrayOf(
    '角', '亢', '저', '房', '心', '尾', '箕',
    '斗', '牛', '女', '虛', '危', '室', '壁',
    '奎', '누', '胃', '昴', '畢', '자', '參',
    '井', '鬼', '柳', '星', '張', '翼', '진'
);

// 병자년 경인월 신미일 기해시 -입춘
var unityear: Int = 1996
var unitmonth: Int = 2
var unitday: Int = 4
var unithour: Int = 22
var unitmin: Int = 8
var unitsec: Int = 0

// 1996 년 음력 1월 1일 합삭 일시
var unitmyear: Int = 1996
var unitmmonth: Int = 2
var unitmday: Int = 19
var unitmhour: Int = 8
var unitmmin: Int = 30
var unitmsec: Int = 0
var moonlength: Int = 42524;
//{ =42524 분 2.9 초 }


// year의 1월 1일부터 year의 month월, day일까지의 날수계산
fun disptimeday(year: Int, month: Int, day: Int): Int {
    var e = 0

    for (i in 1 until month) {
        e = e + 31
        if (i == 2 || i == 4 || i == 6 || i == 11) {
            e = e - 1
            if (i == 2) {
                e = e - 2
                if (year % 4 == 0) e = e + 1
                if (year % 100 == 0) e = e - 1
                if (year % 400 == 0) e = e + 1
                if (year % 4000 == 0) e = e - 1
            }
        }
    }
    return e + day
}


// y1,m1,d1일부터 y2,m2,d2까지의 일수 계산
fun disp2days(y1: Int, m1: Int, d1: Int, y2: Int, m2: Int, d2: Int): Int {
    var p1 = 0
    var p2 = 0
    var p1n = 0
    var pp1 = 0
    var pp2 = 0
    var pr = 0
    var i = 0
    var dis = 0
    var ppp1 = 0
    var ppp2 = 0

    if (y2 > y1) {
        p2 = disptimeday(y2, m2, d2)
        p1 = disptimeday(y1, m1, d1)
        p1n = disptimeday(y1, 12, 31)
        pp1 = y1
        pp2 = y2
        pr = -1
    } else {
        p1 = disptimeday(y2, m2, d2)
        p1n = disptimeday(y1, 12, 31)
        p2 = disptimeday(y1, m1, d1)
        pp1 = y2
        pp2 = y1
        pr = 1
    }

    if (y2 == y1) {
        dis = p2 - p1
    } else {
        dis = p1n - p1
        ppp1 = pp1 + 1
        ppp2 = pp2 - 1

        i = dis

        while (ppp1 <= ppp2) {
            if (ppp1 == -9000 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 4014377
            }
            if (ppp1 == -8000 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 3649135
            }
            if (ppp1 == -7000 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 3283893
            }

            if (ppp1 == -6000 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 2918651
            }
            if (ppp1 == -5000 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 2553408
            }
            if (ppp1 == -4000 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 2188166
            }
            if (ppp1 == -3000 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 1822924
            }


            if (ppp1 == -2000 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 1457682
            }
            if (ppp1 == -1750 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 1366371
            }
            if (ppp1 == -1500 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 1275060
            }
            if (ppp1 == -1250 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 1183750
            }
            if (ppp1 == -1000 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 1092439
            }
            if (ppp1 == -750 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 1001128
            }
            if (ppp1 == -500 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 909818
            }


            if (ppp1 == -250 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 818507
            }
            if (ppp1 == 0 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 727197
            }
            if (ppp1 == 250 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 635887
            }
            if (ppp1 == 500 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 544576
            }
            if (ppp1 == 750 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 453266
            }
            if (ppp1 == 1000 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 361955
            }
            if (ppp1 == 1250 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 270644
            }
            if (ppp1 == 1500 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 179334
            }
            if (ppp1 == 1750 && ppp2 > 1990) {
                ppp1 = 1991
                i = i + 88023
            }

            i = i + disptimeday(ppp1, 12, 31)
            ppp1 = ppp1 + 1
        }
        dis = i
        dis = dis + p2
        dis = dis * pr
    }
    return dis
}


// 특점시점에서 특정시점까지의 분 - 부호주의
fun getminbytime(uy: Int, umm: Int, ud: Int, uh: Int, umin: Int, y1: Int, mo1: Int, d1: Int, h1: Int, mm1: Int): Int {
    var dispday = 0
    var t = 0

    dispday = disp2days(uy, umm, ud, y1, mo1, d1)
    t = dispday * 24 * 60 + (uh - h1) * 60 + (umin - mm1)
    return t
}


// 1996년 2월 4일 22시 8분부터 tmin분 떨어진 날자와 시간을 구하는 프로시져
// 특정시점(udate)으로부터 tmin분 떨어진 날짜를 구하는 프로시져

// 원본 함수는 return 값 없이 Call by refrence 로 구현되어 있음
fun getdatebymin(
    tmin: Int, uyear: Int, umonth: Int, uday: Int, uhour: Int, umin: Int,

    // call by ref
    y1: Int, mo1: Int, d1: Int, h1: Int, mi1: Int
): Array<Int> {
    var t = 0

    var y1_copy = uyear - tmin / 525949
    var mo1_copy = mo1
    var d1_copy = d1
    var h1_copy = h1
    var mi1_copy = mi1

    if (tmin >= 0) {
        y1_copy = y1_copy + 2
        do {
            y1_copy = y1_copy - 1
            t = getminbytime(uyear, umonth, uday, uhour, umin, y1_copy, 1, 1, 0, 0)
        } while (t >= tmin)

        mo1_copy = 13
        do {
            mo1_copy = mo1_copy - 1
            t = getminbytime(uyear, umonth, uday, uhour, umin, y1_copy, mo1_copy, 1, 0, 0)
        } while (t >= tmin)

        d1_copy = 32
        do {
            d1_copy = d1_copy - 1
            t = getminbytime(uyear, umonth, uday, uhour, umin, y1_copy, mo1_copy, d1_copy, 0, 0)
        } while (t >= tmin)

        h1_copy = 24
        do {
            h1_copy = h1_copy - 1
            t = getminbytime(uyear, umonth, uday, uhour, umin, y1_copy, mo1_copy, d1_copy, h1_copy, 0)
        } while (t >= tmin)
        t = getminbytime(uyear, umonth, uday, uhour, umin, y1_copy, mo1_copy, d1_copy, h1_copy, 0)
        mi1_copy = t - tmin
    } else {
        y1_copy = y1_copy - 2
        do {
            y1_copy = y1_copy + 1
            t = getminbytime(uyear, umonth, uday, uhour, umin, y1_copy, 1, 1, 0, 0)
        } while (t < tmin)
        y1_copy = y1_copy - 1
        mo1_copy = 0
        do {
            mo1_copy = mo1_copy + 1
            t = getminbytime(uyear, umonth, uday, uhour, umin, y1_copy, mo1_copy, 1, 0, 0)
        } while (t < tmin)
        d1_copy = 0
        do {
            d1_copy = d1_copy + 1
            t = getminbytime(uyear, umonth, uday, uhour, umin, y1_copy, mo1_copy, d1_copy, 0, 0)
        } while (t < tmin)
        d1_copy = d1_copy - 1
        h1_copy = -1
        do {
            h1_copy = h1_copy + 1
            t = getminbytime(uyear, umonth, uday, uhour, umin, y1_copy, mo1_copy, d1_copy, h1_copy, 0)
        } while (t < tmin)
        h1_copy = h1_copy - 1
        t = getminbytime(uyear, umonth, uday, uhour, umin, y1, mo1_copy, d1_copy, h1_copy, 0)
        mi1_copy = t - tmin
    }

    // y1: Int, mo1: Int, d1: Int, h1: Int, mi1: Int
    return arrayOf(y1_copy, mo1_copy, d1_copy, h1_copy, mi1_copy)
}


// 그레고리력 년월일시분 --> 경과년수,60간지년주,월주,일주,시주
fun sydtoso24yd(
    soloryear: Int, solormonth: Int, solorday: Int, solorhour: Int, solormin: Int,
    so24: Int, so24year: Int, so24month: Int, so24day: Int, so24hour: Int
): Array<Int> {
    var displ2min = 0
    var displ2day = 0
    var monthmin100 = 0
    var j = 0
    var t = 0
    var i = 0

    var so24_copy = so24
    var so24year_copy = so24year
    var so24month_copy = so24month
    var so24day_copy = so24day
    var so24hour_copy = so24hour


    displ2min = getminbytime(
        unityear,
        unitmonth,
        unitday,
        unithour,
        unitmin,
        soloryear,
        solormonth,
        solorday,
        solorhour,
        solormin
    )
    displ2day = disp2days(unityear, unitmonth, unitday, soloryear, solormonth, solorday)
    so24_copy = displ2min / 525949

    if (displ2min >= 0) so24_copy = so24_copy + 1
    so24year_copy = -1 * (so24_copy % 60)
    so24year_copy = so24year_copy + 12
    if (so24year_copy < 0) so24year_copy = so24year_copy + 60
    if (so24year_copy > 59) so24year_copy = so24year_copy - 60  // 년주 구함 끝

    monthmin100 = displ2min % 525949
    monthmin100 = 525949 - monthmin100

    if (monthmin100 < 0) monthmin100 = monthmin100 + 525949
    if (monthmin100 >= 525949) monthmin100 = monthmin100 - 525949

    i = 0
    while (i <= 11) {
        j = i * 2
        if (montharray[j] <= monthmin100 && monthmin100 < montharray[j + 2]) {
            so24month_copy = i
        }
        i++
    }


    i = so24month_copy
    t = so24year_copy % 10
    t = t % 5
    t = t * 12 + 2 + i
    so24month_copy = t   // 월주 구함 끝
    if (so24month_copy > 59) so24month_copy = so24month_copy - 60

    so24day_copy = so24day_copy % 60
    so24day_copy = -1 * so24day_copy
    so24day_copy = so24day_copy + 7

    if (so24day < 0) so24day_copy = so24day_copy + 60
    if (so24day > 59) so24day_copy = so24day_copy - 60 // 일주 구함 끝

    if ((solorhour == 0) || ((solorhour == 1) && (solormin < 30))) i = 0

    if (((solorhour == 1) && (solormin >= 30)) || (solorhour == 2) ||
        ((solorhour == 3) && (solormin < 30))
    ) i = 1

    if (((solorhour == 3) && (solormin >= 30)) || (solorhour == 4) ||
        ((solorhour == 5) && (solormin < 30))
    ) i = 2

    if (((solorhour == 5) && (solormin >= 30)) || (solorhour == 6) ||
        ((solorhour == 7) && (solormin < 30))
    ) i = 3

    if (((solorhour == 7) && (solormin >= 30)) || (solorhour == 8) ||
        ((solorhour == 9) && (solormin < 30))
    ) i = 4

    if (((solorhour == 9) && (solormin >= 30)) || (solorhour == 10) ||
        ((solorhour == 11) && (solormin < 30))
    ) i = 5

    if (((solorhour == 11) && (solormin >= 30)) || (solorhour == 12) ||
        ((solorhour == 13) && (solormin < 30))
    ) i = 6

    if (((solorhour == 13) && (solormin >= 30)) || (solorhour == 14) ||
        ((solorhour == 15) && (solormin < 30))
    ) i = 7

    if (((solorhour == 15) && (solormin >= 30)) || (solorhour == 16) ||
        ((solorhour == 17) && (solormin < 30))
    ) i = 8

    if (((solorhour == 17) && (solormin >= 30)) || (solorhour == 18) ||
        ((solorhour == 19) && (solormin < 30))
    ) i = 9

    if (((solorhour == 19) && (solormin >= 30)) || (solorhour == 20) ||
        ((solorhour == 21) && (solormin < 30))
    ) i = 10

    if (((solorhour == 21) && (solormin >= 30)) || (solorhour == 22) ||
        ((solorhour == 23) && (solormin < 30))
    ) i = 11

    if ((solorhour == 23) && (solormin >= 30)) {
        so24day_copy = so24day_copy + 1
        if (so24day_copy == 60) {
            so24day_copy = 0
        }
        i = 0
    }

    t = so24day_copy % 10
    t = t % 5
    t = t * 12 + i
    so24hour_copy = t
    return arrayOf(so24_copy, so24year_copy, so24month_copy, so24day_copy, so24hour_copy)
}


// 그레고리력 년월일시분 --> 해당일자가 들어있는 시작절기,중기,다음절기
fun SolortoSo24(
    soloryear: Int, solormonth: Int, solorday: Int, solorhour: Int, solormin: Int,
    inginame: Int, ingiyear: Int, ingimonth: Int, ingiday: Int, ingihour: Int, ingimin: Int,
    midname: Int, midyear: Int, midmonth: Int, midday: Int, midhour: Int, midmin: Int,
    outginame: Int, outgiyear: Int, outgimonth: Int, outgiday: Int, outgihour: Int, outgimin: Int
): Array<Int> {
    var i = 0
    var j = 0
    var monthmin100 = 0
    var y1 = 0
    var mo1 = 0
    var d1 = 0
    var h1 = 0
    var mi1 = 0
    var so24 = 0
    var so24year = 0
    var so24month = 0
    var so24day = 0
    var so24hour = 0
    var inginame_copy = inginame
    var ingiyear_copy = ingiyear
    var ingimonth_copy = ingimonth
    var ingiday_copy = ingiday
    var ingihour_copy = ingihour
    var ingimin_copy = ingimin
    var midname_copy = midname
    var midyear_copy = midyear
    var midmonth_copy = midmonth
    var midday_copy = midday
    var midhour_copy = midhour
    var midmin_copy = midmin
    var outginame_copy = outginame
    var outgiyear_copy = outgiyear
    var outgimonth_copy = outgimonth
    var outgiday_copy = outgiday
    var outgihour_copy = outgihour
    var outgimin_copy = outgimin
    var tmin = 0

    val sydtoso24ydResult =
        sydtoso24yd(soloryear, solormonth, solorday, solorhour, solormin, so24, so24year, so24month, so24day, so24hour)
    so24 = sydtoso24ydResult[0]
    so24year = sydtoso24ydResult[1]
    so24month = sydtoso24ydResult[2]
    so24day = sydtoso24ydResult[3]
    so24hour = sydtoso24ydResult[4]

    val displ2min = getminbytime(
        unityear,
        unitmonth,
        unitday,
        unithour,
        unitmin,
        soloryear,
        solormonth,
        solorday,
        solorhour,
        solormin
    )

    monthmin100 = displ2min % 525949
    monthmin100 = 525949 - monthmin100

    if (monthmin100 < 0) monthmin100 = monthmin100 + 525949
    if (monthmin100 >= 525949) monthmin100 = monthmin100 - 525949

    i = so24month % 12 - 2
    if (i == -2) i = 10
    if (i == -1) i = 11

    inginame_copy = i * 2
    midname_copy = i * 2 + 1
    outginame_copy = i * 2 + 2

    j = i * 2
    tmin = displ2min + (monthmin100 - montharray[j])
    val getdatebyminResult1 = getdatebymin(tmin, unityear, unitmonth, unitday, unithour, unitmin, y1, mo1, d1, h1, mi1)
    //call by address - y1: Int, mo1: Int, d1: Int, h1: Int, mi1: Int
    y1 = getdatebyminResult1[0]
    mo1 = getdatebyminResult1[1]
    d1 = getdatebyminResult1[2]
    h1 = getdatebyminResult1[3]
    mi1 = getdatebyminResult1[4]


    ingiyear_copy = 1
    ingimonth_copy = mo1
    ingiday_copy = d1
    ingihour_copy = h1
    ingimin_copy = mi1

    tmin = displ2min + monthmin100 - montharray[j + 1]
    val getdatebyminResult2 = getdatebymin(tmin, unityear, unitmonth, unitday, unithour, unitmin, y1, mo1, d1, h1, mi1)
    y1 = getdatebyminResult2[0]
    mo1 = getdatebyminResult2[1]
    d1 = getdatebyminResult2[2]
    h1 = getdatebyminResult2[3]
    mi1 = getdatebyminResult2[4]

    tmin = displ2min + monthmin100 - montharray[j + 2]
    val getdatebyminResult3 = getdatebymin(tmin, unityear, unitmonth, unitday, unithour, unitmin, y1, mo1, d1, h1, mi1)
    y1 = getdatebyminResult3[0]
    mo1 = getdatebyminResult3[1]
    d1 = getdatebyminResult3[2]
    h1 = getdatebyminResult3[3]
    mi1 = getdatebyminResult3[4]

    outgiyear_copy = y1
    outgimonth_copy = mo1
    outgiday_copy = d1
    outgihour_copy = h1
    outgimin_copy = mi1

//    inginame: Int, ingiyear: Int, ingimonth: Int, ingiday: Int, ingihour: Int, ingimin: Int,
//    midname: Int, midyear: Int, midmonth: Int, midday: Int, midhour: Int, midmin: Int,
//    outginame: Int, outgiyear: Int, outgimonth: Int, outgiday: Int, outgihour: Int, outgimin: Int

    return arrayOf(
        inginame_copy, ingiyear_copy, ingimonth_copy, ingiday_copy, ingihour_copy, ingimin_copy,
        midname_copy, midyear_copy, midmonth_copy, midday_copy, midhour_copy, midmin_copy,
        outginame_copy, outgiyear_copy, outgimonth_copy, outgiday_copy, outgihour_copy, outgimin_copy
    )
}

// 미지의 각도를 0~360도 이내로 만듬
fun degreelow(d: Double): Double {
    var i = 0
    var di: Double = 0.0

    di = d
    i = truncate(di).toInt()
    i = i / 360
    di = di - (360 * i)

    while ((di >= 360) || (di < 0)) {
        if (di > 0) di = di - 360
        else di = di + 360
    }
    return di
}


// 태양황경과 달황경의 차이
// = 0 :합삭
// = 180 : 망
fun moonsundegree(day: Double): Double {
    var sl = 0.0
    var smin = 0.0
    var sd = 0.0
    var sminangle = 0.0
    var sreal = 0.0
    var ml = 0.0
    var mmin = 0.0
    var mminangle = 0.0
    var msangle = 0.0
    var msdangle = 0.0
    var md = 0.0
    var mreal = 0.0

    sl = day * 0.98564736 + 278.956807
    smin = 282.869498 + 0.00004708 * day
    sminangle = PI * (sl - smin) / 180
    sd = 1.919 * sin(sminangle) + 0.02 * sin(2 * sminangle)
    sreal = degreelow(sl + sd)

    ml = 27.836584 + 13.17639648 * day
    mmin = 280.425774 + 0.11140356 * day
    mminangle = PI * (ml - mmin) / 180
    msangle = 202.489407 - 0.05295377 * day
    msdangle = PI * (ml - msangle) / 180
    md = 5.068889 * sin(mminangle) + 0.146111 * sin(2 * mminangle) + 0.01 * sin(3 * mminangle)
    -0.238056 * sin(sminangle) - 0.087778 * sin(mminangle + sminangle)
    +0.048889 * sin(mminangle - sminangle) - 0.129722 * sin(2 * msdangle)
    -0.011111 * sin(2 * msdangle - mminangle) - 0.012778 * sin(2 * msdangle + mminangle);
    mreal = degreelow(ml + md)

    return degreelow(mreal - sreal)
}


// syear,smonth,sday의 전후 합삭일시,망일시 및 합삭일시
fun getlunarfirst(
    syear: Int, smonth: Int, sday: Int,
    //call by ref
    year: Int, month: Int, day: Int, hour: Int, min: Int,
    yearm: Int, monthm: Int, daym: Int, hourm: Int, minm: Int,
    year1: Int, month1: Int, day1: Int, hour1: Int, min1: Int
): Array<Int> {
    var dm = 0.0
    var dem = 0.0
    var d = 0.0
    var de = 0.0
    var pd = 0.0
    var i = 0
    var syear_copy = syear
    var smonth_copy = smonth
    var sday_copy = sday
    var year_copy = year
    var month_copy = month
    var day_copy = day
    var hour_copy = hour
    var min_copy = min
    var yearm_copy = yearm
    var monthm_copy = monthm
    var daym_copy = daym
    var hourm_copy = hourm
    var minm_copy = minm
    var year1_copy = year1
    var month1_copy = month1
    var day1_copy = day1
    var hour1_copy = hour1
    var min1_copy = min1

    dm = disp2days(syear_copy, smonth_copy, sday_copy, 1995, 12, 31).toDouble()
    dem = moonsundegree(dm)
    d = dm
    de = dem

    while (de > 13.5) {
        d = d - 1
        de = moonsundegree(d)
    }

    while (de > 1) {
        d = d - 0.04166666666
        de = moonsundegree(d)
    }

    while (de < 359.99) {
        d = d - 0.000694444
        de = moonsundegree(d)
    }

    d = d + 0.375
    d = d * 1440
    i = -1 * truncate(d).toInt()
    val getdatebyminResult = getdatebymin(i, 1995, 12, 31, 0, 0, year_copy, month_copy, day_copy, hour_copy, min_copy)
    // y1: Int, mo1: Int, d1: Int, h1: Int, mi1: Int
    year_copy = getdatebyminResult[0]
    month_copy = getdatebyminResult[1]
    day_copy = getdatebyminResult[2]
    hour_copy = getdatebyminResult[3]
    min_copy = getdatebyminResult[4]

    d = dm
    de = dem

    while (de < 346.5) {
        d = d + 1
        de = moonsundegree(d)
    }

    while (de < 359) {
        d = d + 0.04166666666
        de = moonsundegree(d)
    }

    while (de > 0.01) {
        d = d + 0.000694444;
        de = moonsundegree(d)
    }

    pd = d
    d = d + 0.375
    d = d * 1440
    i = -1 * truncate(d).toInt()
    val getdatebyminResult2 =
        getdatebymin(i, 1995, 12, 31, 0, 0, year1_copy, month1_copy, day1_copy, hour1_copy, min1_copy)
    year1_copy = getdatebyminResult2[0]
    month1_copy = getdatebyminResult2[1]
    day1_copy = getdatebyminResult2[2]
    hour1_copy = getdatebyminResult2[3]
    min1_copy = getdatebyminResult2[4]


    if (smonth_copy == month1_copy && sday_copy == day1_copy) {
        year_copy = year1_copy
        month_copy = month1_copy
        day_copy = day1_copy
        hour_copy = hour1_copy
        min_copy = min1_copy

        d = pd

        while (de < 347) {
            d = d + 1
            de = moonsundegree(d)
        }
        while (de < 359) {
            d = d + 0.04166666666
            de = moonsundegree(d)
        }
        while (de > 0.01) {
            d = d + 0.000694444
            de = moonsundegree(d)
        }

        d = d + 0.375
        d = d * 1440
        i = -1 * truncate(d).toInt()
        var getdatebyminResult3 =
            getdatebymin(i, 1995, 12, 31, 0, 0, year1_copy, month1_copy, day1_copy, hour1_copy, min1_copy)
        year1_copy = getdatebyminResult3[0]
        month1_copy = getdatebyminResult3[1]
        day1_copy = getdatebyminResult3[2]
        hour1_copy = getdatebyminResult3[3]
        min1_copy = getdatebyminResult3[4]
    }

    d = disp2days(year_copy, month_copy, day_copy, 1995, 12, 31).toDouble()
    d = d + 12
    de = moonsundegree(d)

    while (de < 166.5) {
        d = d + 1
        de = moonsundegree(d)
    }

    while (de < 179) {
        d = d + 0.04166666666
        de = moonsundegree(d)
    }

    while (de < 179.99) {
        d = d + 0.000694444
        de = moonsundegree(d)
    }

    d = d + 0.375
    d = d * 1440
    i = -1 * truncate(d).toInt()
    val getdatebyminResult4 =
        getdatebymin(i, 1995, 12, 31, 0, 0, yearm_copy, monthm_copy, daym_copy, hourm_copy, minm_copy)
    yearm_copy = getdatebyminResult4[0]
    monthm_copy = getdatebyminResult4[1]
    daym_copy = getdatebyminResult4[2]
    hourm_copy = getdatebyminResult4[3]
    minm_copy = getdatebyminResult4[4]

    return arrayOf(
        year_copy, month_copy, day_copy, hour_copy, min_copy,
        yearm_copy, monthm_copy, daym_copy, hourm_copy, minm_copy,
        year1_copy, month1_copy, day1_copy, hour1_copy, min1_copy
    )
}


// 그레고리력 년월일 --> 태음태양력 년,월,일, 평/윤, 대/소
fun solortolunar(
    solyear: Int, solmon: Int, solday: Int,
    // call by ref
    lyear: Int, lmonth: Int, lday: Int,
    lmoonyun: Int, largemonth: Int
): Array<Int> {
    var solyear_copy = solyear
    var solmon_copy = solmon
    var solday_copy = solday
    var lyear_copy = lyear
    var lmonth_copy = lmonth
    var lday_copy = lday
    var lmoonyun_copy = lmoonyun
    var largemonth_copy = largemonth
    var s0 = 0
    var i = 0
    var lnp = FALSE
    var lnp2 = FALSE
    var ingiyear = 0
    var midyear1 = 0
    var midyear2 = 0
    var outgiyear = 0
    var inginame = 0
    var ingimonth = 0
    var ingiday = 0
    var ingihour = 0
    var ingimin = 0
    var midname1 = 0
    var midmonth1 = 0
    var midday1 = 0
    var midhour1 = 0
    var midmin1 = 0
    var midname2 = 0
    var midmonth2 = 0
    var midday2 = 0
    var midhour2 = 0
    var midmin2 = 0
    var outginame = 0
    var outgimonth = 0
    var outgiday = 0
    var outgihour = 0
    var outgimin = 0
    var smomonth = 0
    var smoday = 0
    var smohour = 0
    var smomin = 0
    var smoyear = 0
    var y0 = 0
    var y1 = 0
    var mo0 = 0
    var d0 = 0
    var h0 = 0
    var mi0 = 0
    var mo1 = 0
    var d1 = 0
    var h1 = 0
    var mi1 = 0


    val getlunarfirstResult = getlunarfirst(
        solyear_copy, solmon_copy, solday_copy,
        smoyear, smomonth, smoday, smohour, smomin,
        y0, mo0, d0, h0, mi0,
        y1, mo1, d1, h1, mi1
    )
    smoyear = getlunarfirstResult[0]
    smomonth = getlunarfirstResult[1]
    smoday = getlunarfirstResult[2]
    smohour = getlunarfirstResult[3]
    smomin = getlunarfirstResult[4]
    y0 = getlunarfirstResult[5]
    mo0 = getlunarfirstResult[6]
    d0 = getlunarfirstResult[7]
    h0 = getlunarfirstResult[8]
    mi0 = getlunarfirstResult[9]
    y1 = getlunarfirstResult[10]
    mo1 = getlunarfirstResult[11]
    d1 = getlunarfirstResult[12]
    h1 = getlunarfirstResult[13]
    mi1 = getlunarfirstResult[14]

    lday_copy = disp2days(solyear, solmon, solday, smoyear, smomonth, smoday) + 1

    i = abs(disp2days(smoyear, smomonth, smoday, y1, mo1, d1))
    if (i == 30) largemonth_copy = TRUE
    if (i == 29) largemonth_copy = FALSE

    val solortoSo24Result = SolortoSo24(
        smoyear, smomonth, smoday, smohour, smomin,
        inginame, ingiyear, ingimonth, ingiday, ingihour, ingimin,
        midname1, midyear1, midmonth1, midday1, midhour1, midmin1,
        outginame, outgiyear, outgimonth, outgiday, outgihour, outgimin
    )

    inginame = solortoSo24Result[0]
    ingiyear = solortoSo24Result[1]
    ingimonth = solortoSo24Result[2]
    ingiday = solortoSo24Result[3]
    ingihour = solortoSo24Result[4]
    ingimin = solortoSo24Result[5]
    midname1 = solortoSo24Result[6]
    midyear1 = solortoSo24Result[7]
    midmonth1 = solortoSo24Result[8]
    midday1 = solortoSo24Result[9]
    midhour1 = solortoSo24Result[10]
    midmin1 = solortoSo24Result[11]
    outginame = solortoSo24Result[12]
    outgiyear = solortoSo24Result[13]
    outgimonth = solortoSo24Result[14]
    outgiday = solortoSo24Result[15]
    outgihour = solortoSo24Result[16]
    outgimin = solortoSo24Result[17]


    midname2 = midname1 + 2
    if (midname2 > 24) midname2 = 1
    s0 = montharray[midname2] - montharray[midname1]
    if (s0 < 0) s0 = s0 + 525949
    s0 = -1 * s0

    val result2 = getdatebymin(
        s0, midyear1, midmonth1, midday1, midhour1, midmin1,
        midyear2, midmonth2, midday2, midhour2, midmin2
    )

    midyear2 = result2[0]
    midmonth2 = result2[1]
    midday2 = result2[2]
    midhour2 = result2[3]
    midmin2 = result2[4]

    if (((midmonth1 == smomonth) && (midday1 >= smoday)) || ((midmonth1 == mo1) && (midday1 < d1))) {
        lmonth_copy = (midname1 - 1) / 2 + 1
        lmoonyun_copy = FALSE
    } else {
        if (((midmonth2 == mo1) && (midday2 < d1)) || ((midmonth2 == smomonth) && (midday2 >= smoday))) {
            lmonth_copy = (midname2 - 1) / 2 + 1
            lmoonyun_copy = FALSE
        } else {
            if ((smomonth < midmonth2) && (midmonth2 < mo1)) {
                lmonth_copy = (midname2 - 1) / 2 + 1
                lmoonyun_copy = FALSE
            } else {
                lmonth_copy = (midname1 - 1) / 2 + 1
                lmoonyun_copy = TRUE
            }
        }
    }


    lyear_copy = smoyear
    if (lmonth_copy == 1 && smomonth == 1) lyear_copy = lyear_copy - 1
    if (((lmonth_copy == 1) && lmoonyun_copy == TRUE) || (lmonth_copy == 12) && (lmonth_copy < 6)) {
        val result3 = getdatebymin(
            2880,
            smoyear,
            smomonth,
            smoday,
            smohour,
            smomin,
            midyear1,
            midmonth1,
            midday1,
            midhour1,
            midmin1
        )
        midyear1 = result3[0]
        midmonth1 = result3[1]
        midday1 = result3[2]
        midhour1 = result3[3]
        midmin1 = result3[4]

        val result4 = solortolunar(midyear1, midmonth1, midday1, outgiyear, outgimonth, outgiday, lnp, lnp2)
        outgiyear = result4[0]
        outgimonth = result4[1]
        outgiday = result4[2]
        lnp = result4[3]
        lnp2 = result4[4]

        outgiday = lmonth_copy - 1

        if (outgiday == 0) outgiday = 12

        if (outgiday == outgimonth) {
            if (lmoonyun_copy == TRUE) lmoonyun_copy = FALSE
        } else {
            if (lmoonyun_copy == TRUE) {
                if (lmonth_copy != outgimonth) {
                    lmonth_copy = lmonth_copy - 1
                    if (lmonth_copy == 0) lyear_copy = lyear_copy - 1
                    if (lmonth_copy == 0) lmonth_copy = 12
                    lmoonyun_copy = FALSE
                }
            } else {
                if (lmonth_copy == outgimonth) {
                    lmoonyun_copy = TRUE
                } else {
                    lmonth_copy = lmonth_copy - 1
                    if (lmonth_copy == 0) lyear_copy - 1
                    if (lmonth_copy == 0) lmonth_copy = 12
                }
            }
        }
    }

    return arrayOf(lyear_copy, lmonth_copy, lday_copy, lmoonyun_copy, largemonth_copy)
}


fun getweekday(syear: Int, smonth: Int, sday: Int): Int {
    var d = 0
    var i = 0

    d = disp2days(syear, smonth, sday, unityear, unitmonth, unitday)
    i = d / 7
    d = d - (i * 7)

    while ((d > 6) || (d < 0)) {
        if (d > 6) d = d - 7
        else d = d + 7
    }
    if (d < 0) d = d + 7
    return d
}

fun get28sday(syear: Int, smonth: Int, sday: Int): Int {
    var d = 0
    var i = 0

    d = disp2days(syear, smonth, sday, unityear, unitmonth, unitday)
    i = d / 28
    d = d - (i * 28)

    while ((d > 27) || (d < 0)) {
        if (d > 27) d = d - 28
        else d = d + 28
    }

    d = d - 11
    if (d < 0) d = d + 28
    return d
}

