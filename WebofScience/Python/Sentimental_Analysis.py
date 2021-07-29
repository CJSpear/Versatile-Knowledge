from textblob import TextBlob
import PyPDF2


pdfFileObj = open("/home/caleb/Desktop/University/INFO301/Git/WebOfScience/WebofScience/Python/Testing.pdf", 'rb')
pdfReader = PyPDF2.PdfFileReader(pdfFileObj, strict=False)
if pdfReader.isEncrypted:
    pdfReader.decrypt('')

pageObj = " "
count = pdfReader.numPages
for i in range(count):
    page = pdfReader.getPage(i)
    pageObj += page.extractText()

SentimentScore = TextBlob(pageObj)
print (SentimentScore.sentiment)



# The polarity score is a float within the range [-1.0, 1.0].
if SentimentScore.sentiment.polarity > 0:
    print ("Positive")
elif SentimentScore.sentiment.polarity < 0:
    print ("Negative")
else:
    print ("Neutral")
    
#  The subjectivity is a float within the range [0.0, 1.0] where 0.0 is very objective and 1.0 is very subjective.
if SentimentScore.sentiment.subjectivity >= 0.5:
    print ("Objective")
elif SentimentScore.sentiment.subjectivity < 0.5:
    print ("subjective")
else:
    print ("Woops this shouldn't be happening")