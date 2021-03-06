package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.HibernateException;

import edu.upc.fib.wordguess.data.dao.AdminDAO;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;

/**
 * Classe java corresponent a la classe "Admin" del model de classes de domini
 */
@Entity
@Table(name=Admin.TABLE_ADMIN)
public class Admin extends RegisteredUser implements Serializable {
	
	public static final String TABLE_ADMIN = "admin";
	
	private static final long serialVersionUID = 4243456577935380231L;

	@Column
	private String telephone;
	
	/**
     * WARNING! Never use this constructor!
     * 
     * Its existence is just for Hibernate to work well.
     */
	public Admin() {
		//
	}
	
	private static AdminDAO dao = PostgresDAOFactory.getInstance().getAdminDAO();
	
	public Admin(String name, String surname, String username, String password, String telephone) throws Exception {
		initialize(name, surname, username, password);
		this.telephone = telephone;
		dao.store(this);
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) throws Exception {
		this.telephone = telephone;
		dao.update(this);
	}
	
}
