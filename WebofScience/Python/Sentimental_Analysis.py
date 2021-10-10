from textblob import TextBlob
import docx2txt
import fitz
from textblob.classifiers import NaiveBayesClassifier
import jaydebeapi
import sys
import mysql.connector
from mysql.connector import Error
import pandas as pd
import os
import json
import collections

#
# Call Article_id
Article_ID = sys.argv[1]
val = Article_ID

#Connect to Database
try:

    connection  = jaydebeapi.connect(
        "org.h2.Driver",
        "jdbc:h2:tcp://localhost/~/info301",
        ["sa", ""],
        "WebofScience/Python/h2-1.4.200..jar")

#Word to Text
#docxFileObj = docx2txt.process("WebOfScience/WebofScience/Python/test.docx")   
    def SearchRes():
        result = "null"
        cursor.execute("SELECT ARTICLE_ID FROM ARTICLE WHERE ARTICLE_ID='%{}%'".format(val))
        return result

    pdf_doc = SearchRes()



#PDF To Text
    doc = fitz.open(pdf_doc)
    count = doc.pageCount
#ask for Text_total Location
    for i in range(count):
        text_total = " "
        page = doc.loadPage(i)
        text = page.getText('text')
        text_total = (text_total + " " + text)
    
    pageObj = text_total
    SentimentScore = TextBlob(pageObj)
    print (SentimentScore.sentiment)
    SS = SentimentScore

    def SentimentalScore():
        cursor.execute("update article set sentiment= '{}' where article_id = '{}' ".format(SS, val))
        return result



except:
        print(sys.exc_info())



#For Word Documents (Works but I need to differentiate between incoming files (dont need to double up its a waste of code))
#SentimentScore = TextBlob(docxFileObj)
#print (SentimentScore.sentiment)


# The polarity score is a float within the range [-1.0, 1.0].
if SentimentScore.sentiment.polarity > 0:
    print ("Positive")
    SS_P = ("Positive")
elif SentimentScore.sentiment.polarity < 0:
    print ("Negative")
    SS_P = ("Negative")
else:
    print ("Neutral")
    SS_P = ("Neutral")
#  The subjectivity is a float within the range [0.0, 1.0] where 0.0 is very objective and 1.0 is very subjective.
if SentimentScore.sentiment.subjectivity >= 0.5:
    print ("subjective")
    SS_S = ("subjective")
elif SentimentScore.sentiment.subjectivity < 0.5:
    print ("Objective")
    SS_S =  ("Objective")
else:
    print ("Woops this shouldn't be happening")

print(cl.accuracy(SentimentScore))

