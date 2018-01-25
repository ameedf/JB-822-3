let current_player = "X";
let xWinCounter = 0;
let oWinCounter = 0;
let isGameLocked = false;

let game_arr = [["","",""],["","",""],["","",""]];

function drow_current_turn() {
	let messObj = document.getElementById("player_turn");
	messObj.innerHTML = "<div> Player " + current_player + " it's your turn!</div>"
	messObj.className=  current_player.toLowerCase() + "_style";
}

function reset_game() {
	current_player = "X";
	xWinCounter = 0;
	document.getElementById("x_score").innerHTML = 0;
	oWinCounter = 0;
	document.getElementById("o_score").innerHTML = 0;
	restart_game();

}

function restart_game() {
	game_arr = [["","",""],["","",""],["","",""]];
	

	isGameLocked = false;

	 
	document.getElementById("game_log").innerHTML = "";
	document.getElementById("winner_info").innerHTML = "";

	let messObj = document.getElementById("settings_buttons");
	messObj.style.visibility="hidden";
	
	re_drow_table();
	drow_current_turn(); 
}

function check_winner() {
	let isWin = false;
	let isFull = true;
	let isDiag = true;
	let isSecDiag = true;
	let md = game_arr[0][0];
	let sd = game_arr[2][0];
	let baseClass = '';
	for(let i = 0; i < 3; i++) {
		// check vertical
		if ((game_arr[i][0] == game_arr[i][1] && game_arr[i][1] == game_arr[i][2]) && game_arr[i][0] != "") {
			baseClass = ((game_arr[i][0] == 'X')? 'x_style': 'o_style');
			document.getElementById("cell-"+i+"0").className = baseClass + " winner_path_style";
			document.getElementById("cell-"+i+"1").className = baseClass + " winner_path_style";
			document.getElementById("cell-"+i+"2").className = baseClass + " winner_path_style";
			isWin = true;
		}
		for (let j = 0; j < 3; j++) {
			//check horizontal
			if ((game_arr[0][j] == game_arr[1][j] && game_arr[1][j] == game_arr[2][j]) && game_arr[0][j] != "") {
				baseClass = ((game_arr[0][j] == 'X')? 'x_style': 'o_style');
				document.getElementById("cell-0"+j).className = baseClass + " winner_path_style";
				document.getElementById("cell-1"+j).className = baseClass + " winner_path_style";
				document.getElementById("cell-2"+j).className = baseClass + " winner_path_style";
				isWin = true;
			}
			//check main diagonal
			if((game_arr[i][j] != md && i == j) || md == "") {
				isDiag = false;
			}

			//check second diagonal
			if((game_arr[i][j] != sd && i == (2-j)) || sd == "") {
				isSecDiag = false;
			}

			//check for empty cells	
			if(game_arr[i][j] == "") {
				isFull = false;
			}
		}
	}
	if(isDiag) {
		baseClass = ((game_arr[0][0] == 'X')? 'x_style': 'o_style');
		document.getElementById("cell-00").className = baseClass + " winner_path_style";
		document.getElementById("cell-11").className = baseClass + " winner_path_style";
		document.getElementById("cell-22").className = baseClass + " winner_path_style";
		isWin = true;
	}

	if(isSecDiag) {
		baseClass = ((game_arr[0][2] == 'X')? 'x_style': 'o_style');
		document.getElementById("cell-02").className = baseClass + " winner_path_style";
		document.getElementById("cell-11").className = baseClass + " winner_path_style";
		document.getElementById("cell-20").className = baseClass + " winner_path_style";
		isWin = true;
	}

	if(isDiag || isSecDiag) {
		isWin = true;
	}
	if(isWin || isFull || isDiag) {
		isGameLocked = true;
	}
	return isWin? 1: isFull? 2: 0;
}

function re_drow_table() {
	for(let i = 0; i < 3; i++) {
		for (let j = 0; j < 3; j++) {
			let messObj = document.getElementById("cell-" + i + j);
			if(game_arr[i][j] == "X") {
				messObj.className = "x_style";
			} else if (game_arr[i][j] == "O") {
				messObj.className = "o_style";
			} else {
				messObj.innerHTML = game_arr[i][j];
				messObj.className = "default_style";
			}
		}
	}
}

function cell_click(x,y) {
	if(isGameLocked) {
		return -1;

	}

	re_drow_table();
	drow_current_turn();

	messObj = document.getElementById("game_log").innerHTML = "";

	if(game_arr[x][y] === "") {
		game_arr[x][y] = current_player;
		let messObj = document.getElementById("cell-" + x + y);
		messObj.innerHTML = current_player;
		messObj.className = "last_move";

		let gameStatus = check_winner();
		if( gameStatus == 1) {
			console.log("winner " + current_player + "!");
			if(current_player == "X") {
				xWinCounter++;
				let messObj = document.getElementById("x_score");
				messObj.innerHTML = xWinCounter;
			} else {
				oWinCounter++;
				let messObj = document.getElementById("o_score");
				messObj.innerHTML = oWinCounter;
			}
			let messObj = document.getElementById("winner_info");
			messObj.innerHTML = "<div calss=\"messages\">Player " + current_player + " WIN! </div>";

			messObj = document.getElementById("settings_buttons");
			messObj.style.visibility="visible";
			
			alert("Winner " + current_player + " !");
		} else if (gameStatus == 2){ 
			let messObj = document.getElementById("winner_info");
			messObj.innerHTML = "<div calss=\"messages\">The game ended in a draw!</div>";

			messObj = document.getElementById("settings_buttons");
			messObj.style.visibility="visible";
		} else {
			if(current_player === "X") {
				current_player = "O";
			} else {
				current_player = "X";
			}
			drow_current_turn();
		}

	} else {
		let messObj = document.getElementById("game_log");
		messObj.innerHTML = "<div calss=\"messages\">Illegal player move " + (x+1) +"," + (y+1) +"</div>";

		messObj = document.getElementById("cell-" + x + y);
		messObj.className = "illegal_move";
		console.log(messObj);
		console.log(game_arr);
	}
	console.log(game_arr);
}