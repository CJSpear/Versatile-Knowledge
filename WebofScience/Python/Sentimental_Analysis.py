from textblob import TextBlob
import PyPDF2
import docx2txt
import fitz


#Old PDFFILE to TEXT format
#pdfFileObj = open("Spacing.pdf", 'rb')
#pdfReader = PyPDF2.PdfFileReader(pdfFileObj, strict=False)
#if pdfReader.isEncrypted:
#    pdfReader.decrypt('')  
#count = pdfReader.numPages
#for i in range(count):
#    page = pdfReader.getPage(i)  
#pageObj = pdfReader.getPage(i)
#print (pageObj.extractText())
#SentimentScore = TextBlob(pageObj.extractText())
#print (SentimentScore.sentiment)

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
    pdf_page = page
    text = pdf_page.getText('text')
    text_total = (text_total + " " + text)
    
pageObj = text_total
SentimentScore = TextBlob(pageObj)
print (SentimentScore.sentiment)


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

    



