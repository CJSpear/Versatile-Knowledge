
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
#Search Function

def res():
        try:
                result = None
                cursor.execute("SELECT CUST_ID,NAME FROM WORK")
                result = cursor.fetchall()
                return result
        except Error as err:
                print (f'item error: "{err} "')

results = res()
from_db = []

for result in results:
        result = result
        from_db.append(result)

print (from_db)

cursor.close()
connection.close()
