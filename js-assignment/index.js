
let currentplayer=1;
// creating the object of scores
let score={1:{saved:0,current:0},2:{saved:0,current:0}};

//using unicode for dice faces for animation of rolling dice
const dicefaces=["⚀", "⚁", "⚂", "⚃", "⚄", "⚅"];
function diceRoll(){
    let dice=document.getElementById('dice');
    let randomNo=Math.floor(Math.random()*6); // generating random number 0-5 using Math package.

    // adding classlist for rolling animation of dice rolling
    dice.classList.add("rolling");
    // adding settimeout for waiting animation of dice before switching face
    setTimeout(() => {
        dice.classList.remove("rolling");
        dice.innerText=dicefaces[randomNo]; //updating the face of dice
        let diceValue=randomNo+1; // converting the values to 1-6;
        // resting the current object of players if dicevalue=1 and switching turns
        if(diceValue===1){
            score[currentplayer].current=0;
            switchTurn();
        }
        // if dice values is not 1 then adding the values of dice in current scores;
        else{
            score[currentplayer].current+=diceValue;
        }
        // updating the ui based on if else condition
        updateUI();

    }, 600);
}

// function to save scores();

function saveScores(){
    score[currentplayer].saved += score[currentplayer].current;

    // reseting the current score after saving it to saved scored
    score[currentplayer].current = 0;
    if (score[currentplayer].saved >= 100){//seting up the winning condition{
        document.getElementById('winner').innerText = `${document.getElementById(`player${currentplayer}-name`).value} Wins!`;
        disableButtons(); // calling the funtion for disabling the buttons
    }
    else{
        // switching turn untill one of the players wins
        switchTurn();
    }
    updateUI(); // updating the saved scores in screen
}

function switchTurn(){
    currentplayer=currentplayer===1?2:1 //  switching the turn of player using ternary operator;
    changingCurrentPlayerUI(); // calling the function to change the ui of div current player to show turn of player
}
// function to change the ui of div current player to show turn of player.
function changingCurrentPlayerUI(){
    document.getElementById('player1').classList.remove("active");
    document.getElementById('player2').classList.remove("active");
    document.getElementById(`player${currentplayer}`).classList.add("active");
}
// function to update the ui
function updateUI(){
    document.getElementById('player1-current').innerText = score[1].current;
    document.getElementById('player1-saved').innerText=score[1].saved;
    document.getElementById('player2-current').innerText=score[2].current;
    document.getElementById('player2-saved').innerText=score[2].saved;
}
// function to highlight player after reset
function restGame(){
    score= { 1: { saved: 0, current: 0 }, 2: { saved: 0, current: 0 } };
    document.getElementById('winner').innerText='';
    enableButtons();
    updateUI();
    currentplayer=1;// reset to player 1;
    changingCurrentPlayerUI();
}
function disableButtons() {
    document.getElementById('roll-dice').disabled = true;
    document.getElementById('save-score').disabled = true;
}

function enableButtons() {
    document.getElementById('roll-dice').disabled = false;
    document.getElementById('save-score').disabled = false;
}

document.getElementById('roll-dice').addEventListener('click',  diceRoll);
document.getElementById('save-score').addEventListener('click', saveScores);
document.getElementById('reset-game').addEventListener('click', restGame);

// Highlight Player 1 at the start
changingCurrentPlayerUI();

