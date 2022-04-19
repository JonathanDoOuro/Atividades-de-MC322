package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	boolean valida, cheia;
	int x, y;
	
	Peca (boolean valida, boolean cheia, int x, int y) {
		this.valida = valida;
		this.cheia = cheia;
		this.x = x;
		this.y = y;
	}
	
	public boolean cheia() {
		return this.cheia;
	} 
	
	public boolean valida() {
		return this.valida;
	}
	
	public void esvaziar() {
		this.cheia = false;
	}
	
	public void reviver() {
		this.cheia = true;
	}
	
	
	public boolean mover(Peca destino, Peca meio) {
		if (!destino.cheia() && meio.cheia()) {
			destino.reviver();
			meio.esvaziar();
			this.esvaziar();
			return true; //movimento validado
		}else {
			return false; //movimento não validado
		}
	}
}
