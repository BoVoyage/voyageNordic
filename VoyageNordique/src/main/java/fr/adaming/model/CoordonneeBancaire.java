package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
//@Embeddable
public class CoordonneeBancaire implements Serializable {

	// declaration des attributs
	private int noCarte;
	@Temporal(TemporalType.DATE)
	private Date dateExp;
	private int crypto;

	// declaration des constructeurs
	public CoordonneeBancaire(int noCarte, Date dateExp, int crypto) {
		super();
		this.noCarte = noCarte;
		this.dateExp = dateExp;
		this.crypto = crypto;
	}

	// declaration des getters et setters
	public int getNoCarte() {
		return noCarte;
	}

	public void setNoCarte(int noCarte) {
		this.noCarte = noCarte;
	}

	public Date getDateExp() {
		return dateExp;
	}

	public void setDateExp(Date dateExp) {
		this.dateExp = dateExp;
	}

	public int getCrypto() {
		return crypto;
	}

	public void setCrypto(int crypto) {
		this.crypto = crypto;
	}

	// toString
	@Override
	public String toString() {
		return "CoordonneeBancaire [noCarte=" + noCarte + ", dateExp=" + dateExp + ", crypto=" + crypto + "]";
	}

}
