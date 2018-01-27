let gameOver = false;
let player = "x";
let scoreX = 0;
let scoreO = 0;
let markedCells = 0;
let prev_cell = null;

function startGame() {
    const table = element("board-table");

    //reset game vars
    markedCells = 0;
    gameOver = false;
    player = "x";
    prev_cell = null;

    //reset game board
    let rows = table.rows;
    for (let i=0; i<rows.length; i++) {
        for (let j=0; j<rows.length; j++) {
            rows[i].cells[j].innerHTML = "&nbsp;&nbsp;&nbsp;";
            rows[i].cells[j].bgColor = "white";
        }
    }
    clearError();
    element("msg-area").innerText = "Player X: it's your turn!";
    element("msg-area").style.color = "red";
    element("msg-area").string.fontSize = "large";
}

function playTurn(cellNum) {
    if (!(gameOver))
        markXorO(cellNum.string, player);
    else {
        element("error-area").innerText = "Game Over! Click 'START GAME' to play again.";
        element("error-area").style.color = "black";
        element("error-area").style.fontSize = "large";
    }
}

function markXorO(cellNum, player) {
    if (! (element(cellNum).innerText === "X" || element(cellNum).innerText === "O")) {
        clearError();
        element(cellNum).innerText = player.toUpperCase();
        element(cellNum).bgColor = "lightyellow";
        markedCells += 1;
        if (!(prev_cell === null))
            element(prev_cell).bgColor = "white";

        // if no winner & game not over
        if ((!(checkWin(player.toUpperCase()))) && (!gameOver))
            switchPlayer(cellNum);
    }
    else showError();
}

function switchPlayer(cellNum) {
        if (player === "x") {
            player = "o";
            element("msg-area").innerText = "Player O: it's your turn!";
            element("msg-area").style.color = "green";
            prev_cell = cellNum;
        }
        else {
            player = "x";
            element("msg-area").innerText = "Player X: it's your turn!";
            element("msg-area").style.color = "red";
            prev_cell = cellNum;
        }
}

function checkWin(mark) {
    const table = element("board-table");
    let rows = table.rows;
    let win = false;

    for (let i=0; i<rows.length; i++)
    {
        // check rows
        if (rows[i].cells[0].innerText === mark && rows[i].cells[1].innerText === mark && rows[i].cells[2].innerText === mark) {
            win = true;
            highlightCells(rows, i, 0);
            highlightCells(rows, i, 1);
            highlightCells(rows, i, 2);
        }
        else
        //check columns
        if (rows[0].cells[i].innerText === mark && rows[1].cells[i].innerText === mark && rows[2].cells[i].innerText === mark)
        {
            win = true;
            highlightCells(rows, 0, i);
            highlightCells(rows, 1, i);
            highlightCells(rows, 2, i);
        }
    }
    if (!(win)) {
        // check diagonals
        if (rows[0].cells[0].innerText === mark && rows[1].cells[1].innerText === mark && rows[2].cells[2].innerText === mark) {
            win = true;
            highlightCells(rows, 0, 0);
            highlightCells(rows, 1, 1);
            highlightCells(rows, 2, 2);
        }
        else
        if (rows[0].cells[2].innerText === mark && rows[1].cells[1].innerText === mark && rows[2].cells[0].innerText === mark) {
            win = true;
            highlightCells(rows, 0, 2);
            highlightCells(rows, 1, 1);
            highlightCells(rows, 2, 0);
        }
    }

    if (win)
    {
        if (player === "x") {
            scoreX += 1;
            element(player + "-score-num").innerText = " " + scoreX + " ";
        }
        else {
            scoreO += 1;
            element(player + "-score-num").innerText = " " + scoreO + " ";
        }
        gameOver = true;
        element("msg-area").innerText = "Player " + player.toUpperCase() + ", you're the winner!";
        element("msg-area").style.fontSize = "x-large";
    }

    // board full, nobody won
    if (markedCells === 9 && (!win)) {
        gameOver = true;
        element("msg-area").innerText = "Game Over, nobody wins. Click 'START GAME' to play again.";
        element("msg-area").style.color = "black";
        element("msg-area").style.fontSize = "large";
    }
    
    return win;
}

function showError() {
        element("error-area").innerText = "This square is already marked!";
}

function clearError() {
    element("error-area").innerText = "";
}

function highlightCells(rows, row, col) {
    return rows[row].cells[col].bgColor = "#c0e6c0";
}

function element(id) {
    return document.getElementById(id);
}
