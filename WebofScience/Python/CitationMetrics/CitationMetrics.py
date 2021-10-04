from serpapi import GoogleSearch


def main(s):
    params = {
      "api_key": "1e804d16d07e0a807a06d69d38d0de329c280d6d540b13718c356f17863d4651",
      "engine": "google_scholar",
      "q": str(s),
      "hl": "en"
    }

    search = GoogleSearch(params)
    results = search.get_dict()

    r_id = results['organic_results'][0]['result_id']

    params2 = {
      "api_key": "1e804d16d07e0a807a06d69d38d0de329c280d6d540b13718c356f17863d4651",
      "engine": "google_scholar_cite",
      "q": r_id,
      "hl": "en"
    }

    cite = GoogleSearch(params2)
    cite_r = cite.get_dict()
    cite_r = cite_r['citations']
    print(cite_r['citations'])
    return cite_r

citations = main("word")
