import jaydebeapi
import mysql.connector
from mysql.connector import Error
import pandas as pd
from flask import Flask, request, render_template
import cgi
import cgitb  

cgitb.enable()  
form = cgi.FieldStorage()
connection  = jaydebeapi.connect(
        "org.h2.Driver",
        "jdbc:h2:tcp://localhost/~/info301",
        ["sa", ""],
        "WebofScience/Python/h2-latest.jar")

cursor = connection.cursor()

#app = Flask(__name__)

searchterm =  form.getvalue('SearchInput')

if form.getvalue("dropdown"):
        subject = form.getvalue('dropdown')
else: subject = 'NULL'

typeS = subject

val = searchterm


#Search Function Needs to update for the javascript implementation
def SearchFunction():
        search = ""
        typeS
        #Too be remove using the Javascript functions
        #if types are not needed, but help structure the code in a way so you understand what is done
        typeS = int(typeS)
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
from_db = []

for result in results:
        SearchAmount  +=1
        result = result
        from_db.append(result)

print (from_db)
print (SearchAmount)

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
