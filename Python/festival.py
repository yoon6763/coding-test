import requests
from bs4 import BeautifulSoup

# for i in range(10000, 12000):
#     try:
#         print("idx = ", i)
#         #initialIdx = 11224
#         url = 'https://www.mcst.go.kr/kor/s_culture/festival/festivalView.jsp?pSeq='
#
#         response = requests.get(url + str(i))
#
#         if response.status_code == 200:
#             html = response.text
#             soup = BeautifulSoup(html, 'html.parser')
#             # all code
#             # print(soup)
#
#             title_search = soup.find('div', {'class': 'view_title'})
#             content = soup.find('div', {'class': 'full'})
#
#             # print()
#             # print(content)
#
#             print(title_search.text)
#             for data in soup.findAll('dd', class_="full"):
#                 print(data.text.strip())
#             print("================================================")
#
#         else:
#             print(response.status_code)
#
#     except:
#         print("존재하지 않는 페이지 :", i)

baseUrl = "https://www.mcst.go.kr/kor/s_culture/festival/"


url = "https://www.mcst.go.kr/kor/s_culture/festival/festivalList.jsp"

response = requests.get(url)
if response.status_code == 200:
    html = response.text
    soup = BeautifulSoup(html, 'html.parser')

    # all code
    # print(soup)

    pageCnt = soup.findAll('div', {'class': 'paging pc'})
    lastPage = int(pageCnt[-1].text.split(" ")[-1])

    for pageIdx in range(1, lastPage + 1):
        print("pageIdx = ", pageIdx)
        pageUrl = f"https://www.mcst.go.kr/kor/s_culture/festival/festivalList.jsp?pMenuCD=&pCurrentPage={pageIdx}&pSearchType=&pSearchWord=&pSeq=&pSido=&pOrder=&pPeriod=&fromDt=&toDt="

        pageHtml = response.text
        pageSoup = BeautifulSoup(html, 'html.parser')

        media_search = pageSoup.find('ul', {'class': 'mediaWrap color01'})

        temp = media_search.findAll('a')

        print(temp)
        print(temp)
