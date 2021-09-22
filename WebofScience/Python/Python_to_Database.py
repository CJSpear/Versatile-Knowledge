
import jaydebeapi
import mysql.connector
from mysql.connector import Error
import pandas as pd

connection  = jaydebeapi.connect(
        "org.h2.Driver",
        "jdbc:h2:tcp://localhost/~/test",
        ["sa", ""],
        "WebofScience/Python/h2-latest.jar")

cursor = connection.cursor()




SearchAmount = 0
#Search Function
val = input (" ENTER ")


#Search all in TABLE
def res():
        try:
                result = None
                cursor.execute("SELECT CUST_ID,NAME FROM WORK".format(val))
                result = cursor.fetchall()
                return result
        except Error as err:
                print (f'item error: "{err} "')

results = res()
from_db = []

for result in results:
        SearchAmount  +=1
        result = result
        from_db.append(result)

print (from_db)
print (SearchAmount)

#Search For Specific Result
def SearchRes():
        try:
                result = None        
                cursor.execute("SELECT * FROM WORK WHERE NAME = 'John'")
                result = cursor.fetchall()
                return result
        except Error as err:
                print (f'item error: "{err} "')

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
