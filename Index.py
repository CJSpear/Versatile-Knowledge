
from flask import render_template
from script import database

@app.route("/")
def index():
    to_send=database()
    return render_template("index.html", to_send=to_send)
