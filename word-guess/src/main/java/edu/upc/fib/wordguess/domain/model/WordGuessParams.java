package edu.upc.fib.wordguess.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.upc.fib.wordguess.data.dao.ParamsDAO;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;

@Entity
@Table(name=WordGuessParams.TABLE)
public class WordGuessParams {

	public static final String TABLE = "word_guess_params";
	
	@Id
	@Column
	private String id = WordGuessParams.class.getSimpleName();
	
	@Column
	private int maxErrorsCount;
	
	@Column
	private int nextMatchId;
	
	public WordGuessParams() {
		//
	}
	
	private static ParamsDAO dao = PostgresDAOFactory.getInstance().getParamsDAO();
	
	public WordGuessParams(int maxErrorsCount, int nextMatchId) {
		this.maxErrorsCount = maxErrorsCount;
		this.nextMatchId = nextMatchId;
		try {
			dao.store(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getMaxErrorsCount() {
		return maxErrorsCount;
	}
	
	public void setMaxErrorsCount(int maxErrorsCount) {
		this.maxErrorsCount = maxErrorsCount;
		try {
			dao.update(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getNextMatchId() {
		int next = nextMatchId;
		setNextMatchId(nextMatchId + 1);
		return next;
	}
	
	public void setNextMatchId(int nextMatchId) {
		this.nextMatchId = nextMatchId;
		try {
			dao.update(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}
	
}