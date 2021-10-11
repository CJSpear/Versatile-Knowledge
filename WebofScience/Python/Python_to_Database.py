import jaydebeapi
import sys
import mysql.connector
from mysql.connector import Error
import pandas as pd
import os
import json
import collections

#typeS = sys.argv[1]
#searchterm = sys.argv[2]

typeS = "title"
searchterm = 'test'
#print("starting")

print (typeS)
#searchterm = ("%" + searchterm + "%")

#print(os.environ['CLASSPATH'])

try:

        connection  = jaydebeapi.connect(
                "org.h2.Driver",
                "jdbc:h2:tcp://localhost/~/info301",
                ["sa", ""],
                "WebofScience/Python/h2-latest.jar")

        cursor = connection.cursor()

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
                if typeS == 3:
                        search = 'Keyword'               
                if typeS == 4:
                        search = "Date"
                if typeS == 5:
                        search = 'Department'               
                return search

        SearchAmount = 0
        SearchType = SearchFunction()

        #Search all in TABLE
        #def res():
        #        try:
        #                result = None
        #                cursor.execute("SELECT * FROM ARTICLE")
        #                result = cursor.fetchall()
        #                return result
        #        except Error as err:
        #                print (f'item error: "{err} "')

        #results = res()
        #from_db = []

        #for result in results:
        #        result = result
        #        from_db.append(result)

        #print (from_db)

        #Search For Specific Result
        def SearchRes():
                if SearchType == "Title":
                        result = None        
                        cursor.execute("SELECT * FROM ARTICLE WHERE TITLE like '%{}%'".format(val))
                        result = cursor.fetchall()
                        return result
                      
                        #print (f'item error: "{err} "')
                if SearchType == "Author":
                        result = None        
                        cursor.execute("SELECT * FROM USER WHERE FNAME like '%{}%'".format(val))
                        result = cursor.fetchall()
                        return result

                if SearchType == "Keyword":
                        result = None        
                        cursor.execute("SELECT * FROM ARTICLE WHERE TITLE like '%{}%'".format(val))
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
        #Convert row to have a list
        rowarray_list = []
        for result in results:
                t = (result[0], result[1], result[2], result[3], result[4], result[5], result[6], result[7], result[8], result[9], result[10], result[11])
                rowarray_list.append(t)
        j = json.dumps(rowarray_list)
    
        #Create Objects for the list, converting into JSON
        objects_list = []
        for result in results:
                d = collections.OrderedDict()
                d["id"] = result[0]
                d["Title"] = result[1]
                d["Abstract"] = result[2]
                d["Keyword"] = result[3]
                d["Author"] = result[4]
                d["Verified"] = result[5]
                d["Published"] = result[6]
                d["Flags"] = result[7]
                d["Cited_Count"] = result[8]
                d["Contributed_By"] = result[9]
                d["Verified_By"] = result[10]
                d["Sentiment"] = result[11]
                objects_list.append(d)
        #Send Straight to JSON FILE
        j = json.dumps(objects_list)
        with open('/home/caleb/Desktop/University/WebOfScience/WebOfScience/WebofScience/public/json/messages.json', 'w') as f:
                f.write(j)
        
        
    
        #from_db = [results]

        #for result in results:
                #SearchAmount  +=1
                #result = result
                #from_db.append(result)

        print (results)
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