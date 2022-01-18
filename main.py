from flask import Flask, render_template, request
import random

english_alphabet = {
    1: "a",
    2: "b",
    3: "c",
    4: "d",
    5: "e",
    6: "f",
    7: "g",
    8: "h",
    9: "i",
    10: "j",
    11: "k",
    12: "l",
    13: "m",
    14: "n",
    15: "o",
    16: "p",
    17: "q",
    18: "r",
    19: "s",
    20: "t",
    21: "u",
    22: "v",
    23: "w",
    24: "x",
    25: "y",
    26: "z",
}

score = 0
total = 0

app = Flask(__name__)


@app.route("/", methods=["GET", "POST"])
def index(gcf_request=None):
    local_request = gcf_request if gcf_request else request
    return render_template("index.html")


@app.route("/letter", methods=["GET"])
def letter():
    global score, total
    currentNumber = random.randint(1, 26)
    return render_template(
        "letter.html",
        number=currentNumber,
        language="English",
        score=score,
        total=total,
    )


@app.route("/letter_result", methods=["POST", "GET"])
def letter_result():
    global score, total
    if request.form:
        answer = request.form["answer"]
        currentNumber = request.form["number"]
        # print(type(currentNumber))
        # print(english_alphabet.get(int(currentNumber)))
        # print(answer)
        total += 1

        if english_alphabet.get(int(currentNumber)) == answer:
            score += 1
            return render_template("letter_result.html", score=score, total=total)
        else:
            return render_template("letter_wrong.html", score=score, total=total)

    else:
        return render_template("/letter_wrong.html", score=score, total=total)


if __name__ == "__main__":
    import os

    app.run(
        debug=True,
        threaded=True,
        host="0.0.0.0",
        port=int(os.environ.get("PORT", 8080)),
    )
