import feedparser

news_feed = feedparser.parse("http://www.money.pl/rss/")
news_feed_entries = news_feed.entries

print("Most recent arrticles for today:")
for i in range(10):
    print("------------------------")
    print(i + 1, news_feed_entries[i].title)
    print(news_feed_entries[i].summary)
    print(news_feed_entries[i].link)
