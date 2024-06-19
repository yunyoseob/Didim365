import yaml
from scrapy.crawler import CrawlerProcess
from scrapy.utils.project import get_project_settings
import os
from apscheduler.schedulers.blocking import BlockingScheduler
import subprocess

def load_config(config_path):
    with open(config_path, 'r', encoding='utf-8') as file:
        return yaml.safe_load(file)
    

def run_web_spiders(keyword):
    subprocess.run(['scrapy', 'crawl', 'web_scraper', '-a', f'keyword={keyword}'])

if __name__ == "__main__":
    scheduler = BlockingScheduler()

    config_path = os.path.join(os.path.dirname(__file__), 'config.yml')
    config = load_config(config_path)
    
    tool_config = config.get('scrapy', {}).get('tool', {})

    if 'web' in tool_config:
        web_config = tool_config['web']
        keyword = ""
        for word in web_config['search_keywords']:
            keyword += word
        #process.crawl('web_scraper', keyword=keyword)
        interval_seconds = tool_config.get('web', {}).get('interval_seconds', 30)
        scheduler.add_job(run_web_spiders, 'interval', seconds=interval_seconds, args=[keyword])
        print(f"스케줄러가 시작되었습니다. {interval_seconds}초마다 크롤링을 수행합니다.")
        scheduler.start()
    #if 'api' in tool_config:
    #    api_config = tool_config['api']

    
    
    