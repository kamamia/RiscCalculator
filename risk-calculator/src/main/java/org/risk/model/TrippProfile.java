package org.risk.model;

import java.math.BigDecimal;

/**
 * <p>
 * TrippProfile POJO
 * </p>
 * 
 * @author akamami
 * @author htazouti
 * 
 * @since January 29, 2015
 * @version 1.0
 *
 */
public class TrippProfile {

	private BigDecimal id;

	private BigDecimal age;

	private BigDecimal sexe;

	private BigDecimal gb;

	private BigDecimal ci;

	private BigDecimal fails;

	/** Getters and setters **/

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getAge() {
		return age;
	}

	public void setAge(BigDecimal age) {
		this.age = age;
	}

	public BigDecimal getSexe() {
		return sexe;
	}

	public void setSexe(BigDecimal sexe) {
		this.sexe = sexe;
	}

	public BigDecimal getGb() {
		return gb;
	}

	public void setGb(BigDecimal gb) {
		this.gb = gb;
	}

	public BigDecimal getCi() {
		return ci;
	}

	public void setCi(BigDecimal ci) {
		this.ci = ci;
	}

	public BigDecimal getFails() {
		return fails;
	}

	public void setFails(BigDecimal fails) {
		this.fails = fails;
	}

	@Override
	public String toString() {

		return "TrippProfile=: [ id=" + this.id + " age=" + age + " sexe=" + sexe + " gb=" + gb + "]";

	}

}
