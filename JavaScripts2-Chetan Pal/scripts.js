document.addEventListener("DOMContentLoaded", async function () {
    const params = new URLSearchParams(window.location.search); // using URLSeacrchParams to get passed parameter from index.html
    const category = params.get("category"); //getting the category parameter from psarams
    const difficulty = params.get("difficulty");// getting the difficulty parameter from param

    const questionNumberElement = document.getElementById("question-number"); // getting the current question no
    const questionText = document.getElementById("question-text"); 
    const optionsContainer = document.getElementById("options");
    const timerElement = document.getElementById("time-left");
    const scoreElement = document.getElementById("score-value");

    let questions = []; // intializing the question array
    let currentQuestionIndex = 0;
    let score = 0;
    let timer;
        // function to fetch question from open trivia database api 
    async function fetchQuestions() {
        const url = `https://opentdb.com/api.php?amount=15&category=${category}&difficulty=${difficulty}&type=multiple`;
        try {
            const response = await fetch(url);
            if (!response.ok) throw new Error("Failed to fetch questions");
            const data = await response.json();
            return data.results;
        } catch (error) {
            console.error("Error fetching questions:", error);
            alert("Failed to load questions. Please try again.");
            window.location.href = "index.html";
            return [];
        }
    }

    questions = await fetchQuestions();
    if (questions.length === 0) return; // Stop execution if no questions are loaded

    loadNextQuestion();

    // function to run timer
    function startTimer() {
        let timeLeft = 15;
        timerElement.innerText = timeLeft;
        timer = setInterval(() => {
            timeLeft--;
            timerElement.innerText = timeLeft;

            if (timeLeft <= 0) {
                clearInterval(timer);
                showCorrectAnswer();
                setTimeout(loadNextQuestion, 2000);
            }
        }, 1000);
    }
    // function to load next question after the selected answer or time out
    function loadNextQuestion() {
        if (currentQuestionIndex >= questions.length) {
            localStorage.setItem("score", score);
            window.location.href = "results.html"; // Redirect to results page
            return;
        }

        clearInterval(timer);
        optionsContainer.innerHTML = "";
        let question = questions[currentQuestionIndex];

        if (!question) {
            console.error("No question data found.");
            return;
        }

        questionNumberElement.innerText = `Question ${currentQuestionIndex + 1}`; // Update question number
        questionText.innerHTML = decodeHTML(question.question);
        let answers = [...question.incorrect_answers, question.correct_answer];
        answers.sort(() => Math.random() - 0.5);

        answers.forEach(answer => {
            let button = document.createElement("button");
            button.innerHTML = decodeHTML(answer);
            button.classList.add("option-btn");
            button.onclick = () => checkAnswer(answer, question.correct_answer);
            optionsContainer.appendChild(button);
        });

        startTimer();
    }

    function checkAnswer(selectedAnswer, correctAnswer) {
        clearInterval(timer);
        let buttons = optionsContainer.children;

        for (let btn of buttons) {
            if (btn.innerHTML === decodeHTML(correctAnswer)) {
                btn.classList.add("correct");
            } else if (btn.innerHTML === decodeHTML(selectedAnswer)) {
                btn.classList.add("wrong");
            }
            btn.disabled = true;
        }

        if (selectedAnswer === correctAnswer) {
            score++;
            scoreElement.innerText = score;
        }

        currentQuestionIndex++;
        setTimeout(loadNextQuestion, 2000);
    }
// function to show correct answer
    function showCorrectAnswer() {
        [...optionsContainer.children].forEach(button => { // converting the html colletion into js array using spread operator ...
            if (button.innerHTML === decodeHTML(questions[currentQuestionIndex].correct_answer)) {
                button.classList.add("correct");
            } else {
                button.classList.add("wrong");
            }
            button.disabled = true;
        });
        currentQuestionIndex++;
        setTimeout(loadNextQuestion, 2000);
    }
// decode HTML entities into their corresponding characters.
    function decodeHTML(html) {
        let txt = document.createElement("textarea");
        txt.innerHTML = html;
        return txt.value;
    }
});
