import scrapy
from urllib.parse import urlencode
from bs4 import BeautifulSoup

class WebScraper(scrapy.Spider):
    name = 'web_scraper'

    def __init__(self, keyword=None, *args, **kwargs):
        super(WebScraper, self).__init__(*args, **kwargs)
        self.keyword = keyword

    def start_requests(self):
        #query = urlencode({'q': self.keyword})
        keyword = self.keyword
        print(f"keyword : {keyword}")
        #urls =  [ f'https://www.google.com/search?{keyword}' ]
        urls = ['https://www.donga.com/news/Series/70010000000785']
        for url in urls:
            print(f"url : {url}")
            yield scrapy.Request(url=url, callback=self.parse, headers={
                'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3'
            })

    def parse(self, response):
        print("=============================================")  
        soup = BeautifulSoup(response.text, 'lxml')

        # 불필요한 스크립트와 스타일 제거
        for script_or_style in soup(['script', 'style']):
            script_or_style.decompose()

        # 텍스트 추출 및 불필요한 공백 제거
        all_text = ' '.join(soup.stripped_strings)

        print(all_text)  # 전체 텍스트 출력
        
        yield {
            'all_text': all_text
        }
        print("=============================================")  