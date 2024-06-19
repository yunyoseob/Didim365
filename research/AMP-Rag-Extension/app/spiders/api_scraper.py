import scrapy

class ApiScraper(scrapy.Spider):
    name = 'api_scraper'

    def __init__(self, keyword=None, *args, **kwargs):
        super(ApiScraper, self).__init__(*args, **kwargs)
        self.keyword = keyword

    def start_requests(self):
        urls = [f'https://api.example.com/search?q={self.keyword}']
        for url in urls:
            yield scrapy.Request(url=url, callback=self.parse)

    def parse(self, response):
        # 데이터 파싱 로직
        pass