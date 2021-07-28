from textblob import TextBlob
import PyPDF2

pdfFileObj = open("Testing.pdf", 'rb')
pdfReader = PyPDF2.PdfFileReader(pdfFileObj, strict=False)
if pdfReader.isEncrypted:
    pdfReader.decrypt('')
    
count = pdfReader.numPages
for i in range(count):
    page = pdfReader.getPage(i)
    
pageObj = pdfReader.getPage(2)
#print (pageObj.extractText())
SentimentScore = TextBlob(pageObj.extractText())
print (SentimentScore.sentiment)

if SentimentScore.sentiment.polarity > 0:
    print ("Positive")
elif SentimentScore.sentiment.polarity < 0:
    print ("Negative")
else:
    print ("Neutral")
    
if SentimentScore.sentiment.subjectivity >= 0.5:
    print ("Objective")
elif SentimentScore.sentiment.subjectivity < 0.5:
    print ("subjective")
else:
    print ("Woops this shouldn't be happening")

    



