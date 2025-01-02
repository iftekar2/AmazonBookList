import requests
from bs4 import BeautifulSoup
from fake_useragent import UserAgent

# Amazon product URL
url = "https://www.amazon.com/s?k=book+amazon&hvadid=580746852665&hvdev=c&hvlocphy=9212665&hvnetw=g&hvqmt=e&hvrand=4094225047110703921&hvtargid=kwd-297247493513&hydadcr=9990_13532529&tag=googhydr-20&ref=pd_sl_4cc4g5wb0_e"

# Set headers with a random user agent
ua = UserAgent()
headers = {
    "User-Agent": ua.random,
    "Accept-Language": "en-US,en;q=0.9",
}

# Send the HTTP request
response = requests.get(url, headers=headers)

if response.status_code == 200:
    soup = BeautifulSoup(response.content, 'lxml')
    # Example: Extract the product title
    title = soup.find(id="productTitle")
    print("Product Title:", title.get_text(strip=True))
else:
    print("Failed to retrieve the page:", response.status_code)
