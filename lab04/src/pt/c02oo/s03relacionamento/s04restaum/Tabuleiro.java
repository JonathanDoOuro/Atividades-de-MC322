package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	Peca tabuleiro[][] = new Peca[7][7];
	char board[][];
	Tabuleiro (char board[][]) {
		this.board = board;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (board[i][j] == "P".charAt(0))
					tabuleiro[i][j] = new Peca(true, true, i, j);
				else if (board[i][j] == " ".charAt(0))
					tabuleiro[i][j] = new Peca(false, false, i, j);
				else
					tabuleiro[i][j] = new Peca(true, false, i, j);
			}
		}		
	}
	
	public char[][] mostra() {
		return this.board;
	}
	
	public void movimento(String mov) {
 		int origemX = mov.charAt(0) - 'a';
		int origemY = Integer.parseInt(mov.substring(1, 2)) - 1;
		int destinoX = mov.charAt(3) - 'a';
		int destinoY = Integer.parseInt(mov.substring(4, 5)) - 1;
		Peca pecaDoMeio = null;
		if (origemY == destinoY && (Math.abs(origemX - destinoX) == 2)) { //movimento horizontal e valido
			if ((origemX - destinoX) > 0) {
				pecaDoMeio = tabuleiro[origemX - 1][destinoY];
			}else {
				pecaDoMeio = tabuleiro[origemX + 1][destinoY];
			}
		}else if (destinoX == origemX && (Math.abs(origemY - destinoY) == 2)){ //movimento vertical e valido
			if ((origemY - destinoY) > 0) {
				pecaDoMeio = tabuleiro[origemX][origemY - 1];
			}else {
				pecaDoMeio = tabuleiro[origemX][origemY + 1];
			}
		}
		if (tabuleiro[origemX][origemY].mover(tabuleiro[destinoX][destinoY], pecaDoMeio) == true) {
			this.board[origemY][origemX] = '-'; 
			this.board[destinoY][destinoX] = 'P';
			this.board[pecaDoMeio.y][pecaDoMeio.x] = '-';
		} 
	}
}