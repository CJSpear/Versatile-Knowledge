from textblob import TextBlob
import docx2txt
import fitz

#Word to Text
docxFileObj = docx2txt.process("test.docx")

#PDF To Text
pdf_doc ="Testing.pdf"
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

    



