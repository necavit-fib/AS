package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

public class LetterBoxPK implements Serializable {
	/**
	 * Classe necess�ria per poder fer em mapping de Hibernate ja que LetterBox t� una clau composta
	 * */
	private static final long serialVersionUID = -2730791475497868230L;

	private int position;
	
	private int matchId;
	
	public LetterBoxPK() {
		//
	}
	
	public LetterBoxPK(int position, int matchId) {
		this.position = position;
		this.matchId = matchId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LetterBoxPK) {
			LetterBoxPK pk = (LetterBoxPK) obj;
			return position == pk.position && matchId == pk.matchId; 
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return position + matchId;
	}
	
}
