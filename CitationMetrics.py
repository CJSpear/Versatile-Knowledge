from serpapi import GoogleSearch

#main function, returns 2 variables
#first is string list of titles of the first 10 citations
#second is integer of total citations
def main(s):
    #parameters for first search to get result_id
    #api_key is private and personal, can be changed,
    #follow instructions through their website
    #engine has to be google_scholar
    #q is for query, what you wish to query from google scholar
    #hl is language, which is en for english
    params = {
      "api_key": "1e804d16d07e0a807a06d69d38d0de329c280d6d540b13718c356f17863d4651",
      "engine": "google_scholar",
      "q": str(s),
      "hl": "en"
    }
    
    #using SerpAPI to get json of search
    search = GoogleSearch(params)
    results = search.get_dict()

    #getting result_id and total citation number from json
    r_id = results['organic_results'][0]['link']
    total = results['organic_results'][0]['inline_links']['cited_by']['total']

    #second search parameters to get the first 10 citations
    #parameter cites replaces q for query to get the citations
    params2 = {
      "api_key": "1e804d16d07e0a807a06d69d38d0de329c280d6d540b13718c356f17863d4651",
      "engine": "google_scholar",
      "cites": r_id,
      "hl": "en"
    }

    #using SerpAPI to get json of citations
    cite = GoogleSearch(params2)
    cite_r = cite.get_dict()
    cite_r = cite_r['organic_results']

    #formatting so just title is given
    ten_results = []
    for i in cite_r:
            ten_results.append(i['title'])
            
    return ten_results, int(total)
    print (ten_results)

