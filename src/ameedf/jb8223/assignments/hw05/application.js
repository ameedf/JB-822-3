let game = {};
let currentPlayer = "X";

// Runtime functions

function startGame() {
  clearBoard();
  game = {
    sections: {
      "X": {},
      "O": {}
    },
    hasWinner: function() {
      return (verticalLine() || horizontalLine() || diagonalLine());
    },
    hasNoFreeSections: function() {
      return isFull();
    }
  };
  setActivePlayer();
  resetColors();
  enableBoard();
  display("Now it is turn of Mr. " + currentPlayer);
}

function makeMove(ev) {
  let sectionID = ev.target.id;
  ev.target.innerText = currentPlayer;
  game.sections[currentPlayer][sectionID] = true;

  if (game.hasWinner()) {
    display("We have a winner! Congratulations, Mr. " + currentPlayer + "!");
    fillWinnerLine();
    markRecentSection(undefined);
    updateScore();
    disableBoard();
    changePlayer();
    return;
  }

  if (game.hasNoFreeSections()) {
    display("No more space left. Start again!");
    markRecentSection(undefined);
    return;
  }

  markRecentSection(sectionID);
  changePlayer();
  disableSector(ev.target);
  display("Now it is turn of Mr. " + currentPlayer);
  setActivePlayer();
};


// Functions to check winning combinations

function horizontalLine() {
  for (var i = 1; i <= 3; i++) {
   if (checkLine( [("A" + i), ("B" + i), ("C" + i) ] )) {return true};
  }
}

function verticalLine() {
  let chars = ["A", "B", "C"];
  for (var i = 0; i < chars.length; i++) {
    if (checkLine( [(chars[i] + 1), (chars[i] + 2), (chars[i] + 3)] )) {return true};
  }
}

function diagonalLine() {
  if (checkLine(["A1","B2","C3"]) || checkLine(["C1","B2","A3"])) {return true};
}

function checkLine(args) {
  let sections = game.sections[currentPlayer];
  if (sections[args[0]] && sections[args[1]] && sections[args[2]]) {
    game.winnerLine = args;
    return true;
  }
}


// Game logic functions

function isFull() {
  let ids = ["A1", "B1", "C1", "A2", "B2", "C2", "A3", "B3", "C3"]
  for (var i = 0; i < ids.length; i++) {
    if (!game.sections["X"][ids[i]] && !game.sections["O"][ids[i]]) {
      return false;
    }
  };
  return true;
}

function changePlayer() {
  currentPlayer = (currentPlayer == "X") ? "O" : "X";
}


// UI functions

function enableBoard() {
  let elements = document.getElementsByClassName("content");
  for (var i = 0; i < elements.length; i++) {
    elements[i].addEventListener("click", makeMove);
  }
}

function disableBoard() {
  let elements = document.getElementsByClassName("content");
  for (var i = 0; i < elements.length; i++) {
    disableSector(elements[i]);
  }
}

function disableSector(item) {
  item.removeEventListener("click", makeMove);
}

function updateScore() {
  let element = document.getElementById(currentPlayer + '-player-score');
  let currentScore = parseInt(element.innerText);
  element.innerText = ++currentScore;
}

function clearBoard() {
  let chars = ["A", "B", "C"];
  for (var i = 0; i < chars.length; i++) {
    for (var j = 1; j <= 3; j++) {
      document.getElementById(chars[i] + j).innerText = "";
    }
  }
}

function resetScore() {
  document.getElementById("X-player-score").innerText = 0;
  document.getElementById("O-player-score").innerText = 0;
}

function display(msg) {
  document.getElementById("messageBox").innerText = msg;
}

function setActivePlayer() {
  let elements = document.getElementsByClassName("player");
  for (var i = 0; i < elements.length; i++) {
    elements[i].classList.remove("active");
  }
  document.getElementById(currentPlayer + "-player-block").classList.add("active");
}

function fillWinnerLine() {
  for (var i = 0; i < game.winnerLine.length; i++) {
    document.getElementById(game.winnerLine[i]).classList.add("winner");
  }
}

function resetColors() {
  elements = document.getElementsByClassName("content");
  for (var i = 0; i < elements.length; i++) {
    elements[i].classList.remove("winner");
  }
}

function markRecentSection(sectionID) {
  elements = document.getElementsByClassName("content");
  for (var i = 0; i < elements.length; i++) {
    if (elements[i].id == sectionID) {
      elements[i].classList.add("recent-section");
    } else {
      elements[i].classList.remove("recent-section");
    }
  }
}
