import os
import pickle

class SearchEngine:
    def __init__(self):
        self.file_index = [] # directory listing returned by os.walk()
        self.results = [] # search results returned from search method
        self.matches = 0 # count of records matched
        self.records = 0 # count of records searched
 

    def search(self, term, search_type = 'contains'):
        #search for term based on search type

        self.results.clear()
        self.matches = 0
        self.records = 0

        for path, files in self.file_index:
            for file in files:
                self.records +=1
                if (search_type == 'contains' and term.lower() in file.lower(),
                    search_type == 'startswith' and file.lower().startswith(term.lower()),
                    search_type == 'endswith' and file.lower().endswith(term.lower())):



                    result = path.replace('\\','/') +  '/' + file
                    self.results.append(result)
                    self.matches +=1
                else:
                    continue
 
        with open('search_results.txt','w') as f:
            for row in self.results:
                f.write(row + '\n')

def test1():
    s = SearchEngine()
    s.search('test')

    print(' There were {:,d} matches out of {:,d}'.format(s.matches, s.records))
    for match in s.results:
        print (match)
        print (path)



pathing = '/home'
dirs = os.listdir(pathing)
for file in dirs:
    if file.endswith('.txt'):
        print (file)



test1()
        

