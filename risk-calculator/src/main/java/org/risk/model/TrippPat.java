package org.risk.model;

import java.math.BigDecimal;

/**
 * <p>
 * TrippPat POJO
 * </p>
 * 
 * @author akamami
 * @author htazouti
 * 
 * @since January 29, 2015
 * @version 1.0
 *
 */
public class TrippPat {

	private BigDecimal id;

	private BigDecimal age;

	private BigDecimal sexe;

	private BigDecimal gb;

	private BigDecimal ci;

	private BigDecimal fails;

	/** Getters and Setters **/

	/**
	 * @return
	 */
	public BigDecimal getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public BigDecimal getAge() {
		return age;
	}

	/**
	 * @param age
	 */
	public void setAge(BigDecimal age) {
		this.age = age;
	}

	/**
	 * @return
	 */
	public BigDecimal getSexe() {
		return sexe;
	}

	/**
	 * @param sexe
	 */
	public void setSexe(BigDecimal sexe) {
		this.sexe = sexe;
	}

	/**
	 * @return
	 */
	public BigDecimal getGb() {
		return gb;
	}

	/**
	 * @param gb
	 */
	public void setGb(BigDecimal gb) {
		this.gb = gb;
	}

	/**
	 * @return
	 */
	public BigDecimal getCi() {
		return ci;
	}

	/**
	 * @param ci
	 */
	public void setCi(BigDecimal ci) {
		this.ci = ci;
	}

	/**
	 * @return
	 */
	public BigDecimal getFails() {
		return fails;
	}

	/**
	 * @param fails
	 */
	public void setFails(BigDecimal fails) {
		this.fails = fails;
	}

}
