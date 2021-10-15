import jaydebeapi
import sys
import mysql.connector
from mysql.connector import Error
import pandas as pd
import os
import json
import collections
import psycopg2
# from bson import json_util


#import values from JAVA
searchterm = sys.argv[1]
typeS = sys.argv[2]

#searchterm = "title"
#typeS = 'test'
# print("searchterm is  :" + searchterm);
# print ("catagory is  :" + typeS);

#searchterm = ("%" + searchterm + "%")

#print(os.environ['CLASSPATH'])

try:
        
        connection  = jaydebeapi.connect(
                "org.h2.Driver",
                "jdbc:h2:tcp://localhost/info301",
                ["sa", "sa"],
                "C:\WebOfScience\WebofScience\Python\h2-latest.jar")

        cursor = connection.cursor()

        #conn = psycopg2.connect("dbname=org.h2.Driver user=sa password='sa' host=~/info301 port=9092")
        #cursor = connection.cursor()
        val = searchterm

        #print("connected")

        def SearchFunction():
                search = ""

                #Too be remove using the Javascript functions
                #if types are not needed, but help structure the code in a way so you understand what is done
                if typeS == 'title':
                        search = 'Title'               
                if typeS == 'author':
                        search = "Author"
                if typeS == "keyword":
                        search = "Keyword"           
                if typeS == 4:
                        search = "Date"
                if typeS == 5:
                        search = 'Department'               
                return search

        SearchAmount = 0
        SearchType = SearchFunction()


        #Search For Specific Result
        def SearchRes():
                if SearchType == "Title":
                        result = None        
                        cursor.execute("SELECT * FROM ARTICLE WHERE TITLE LIKE '%{}%'".format(val))
                        result = cursor.fetchall()
                        return result
                      
                        #print (f'item error: "{err} "')
                if SearchType == "Author":
                        result = None        
                        cursor.execute("SELECT * FROM ARTICLE WHERE AUTHOR like '%{}%'".format(val))
                        result = cursor.fetchall()
                        return result

                if SearchType == "Keyword":
                        result = None        
                        cursor.execute("SELECT * FROM ARTICLE WHERE KEYWORD like '%{}%'".format(val))
                        result = cursor.fetchall()
                        return result

                #if SearchType == "Date":
                        #result = None        
                        #cursor.execute("SELECT * FROM ARTICLE WHERE  = '{}'".format(val))
                        #result = cursor.fetchall()
                        #return result

                if SearchType == "Department":
                        result = None        
                        cursor.execute("SELECT * FROM USER WHERE DEPARTMENT = '%{}%'".format(val))
                        result = cursor.fetchall()
                        return result


                

        results = SearchRes()
        #print (results)
        #Convert row to have a list
        rowarray_list = []
        
        for result in results:
                t = (result[0], result[2], result[3], result[4], result[5], result[6], result[7], result[8], result[9], result[10], result[11])
                rowarray_list.append(t)
        #print(t);
        j = json.dumps(rowarray_list)

    
        #Create Objects for the list, converting into JSON
        objects_list = []
        for result in results:
                d = collections.OrderedDict()
                d["id"] = result[0]
                #d["file"] = result [1]
                d["Title"] = result[2]
                d["Abstract"] = result[3]
                d["Keyword"] = result[4]
                d["Author"] = result[5]
                d["Verified"] = result[6]
                d["Published"] = result[7]
                d["Flags"] = result[8]
                d["Cited_Count"] = result[9]
                d["Contributed_By"] = result[10]
                d["Verified_By"] = result[11]
                d["Sentiment"] = result[12]
                objects_list.append(d)
#       Convert String into JSON
        j = json.dumps(objects_list)
        print (j)
        #Send Straight to JSON FILE
        with open('C:\WebOfScience\WebofScience\public\js\json\messages.json', 'w') as f:
                f.write(j)
        
        
    
        #from_db = [results]

        #for result in results:
                #SearchAmount  +=1
                #result = result
                #from_db.append(result)

        
        #print (SearchAmount)

        cursor.close()
        connection.close()


        #Send Search Information Straight to HTML pages
        #@app.route('/')
        #def index():
        #        if request.method == 'GET':
        #                library = from_db
        #                return render_template("seach.html", library=library)


        #if __name__ == "__main__":
        #    app.run(debug=True)

except:
        print(sys.exc_info())