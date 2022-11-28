import requests
from bs4 import BeautifulSoup


for i in range(10000, 12000):
    try:
        print("idx = ", i)
        #initialIdx = 11224
        url = 'https://www.mcst.go.kr/kor/s_culture/festival/festivalView.jsp?pSeq='

        response = requests.get(url + str(i))

        if response.status_code == 200:
            html = response.text
            soup = BeautifulSoup(html, 'html.parser')
            # all code
            # print(soup)

            title_search = soup.find('div', {'class': 'view_title'})
            content = soup.find('div', {'class': 'full'})

            # print()
            # print(content)

            print(title_search.text)
            for data in soup.findAll('dd', class_="full"):
                print(data.text.strip())
            print("================================================")

        else:
            print(response.status_code)

    except:
        print("존재하지 않는 페이지 :", i)

