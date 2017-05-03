package org.mcgill.risk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*to check with Hicham
 */

@Entity
@Table(name = "CODEGEN")
public class Codegen {

	@Id
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "CODE", nullable = false)
	private String code;

	@Column(name = "MONOGRAPH_NO", nullable = true)
	private String monographNo;

	@Column(name = "OLD_AHFS_CLASS", nullable = true)
	private String oldAhfsClass;

	@Column(name = "NEW_AHFS_CLASS", nullable = true)
	private String newAhfsClass;

	@ManyToOne
	@JoinColumn(name = "DESCRIPTION_LVID")
	private LocalizedValue description;

	@Column(name = "MODIFICATION_TRANSACTION_ID", nullable = false)
	private Long modificationTransaction;

	@Column(name = "CREATION_TRANSACTION_ID", nullable = false)
	private Long creationTransaction;

	@Column(name = "ALIASES_EN", nullable = true)
	private String aliasesEn;

	@Column(name = "ALIASES_FR", nullable = true)
	private String aliasesFr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMonographNo() {
		return monographNo;
	}

	public void setMonographNo(String monographNo) {
		this.monographNo = monographNo;
	}

	public String getOldAhfsClass() {
		return oldAhfsClass;
	}

	public void setOldAhfsClass(String oldAhfsClass) {
		this.oldAhfsClass = oldAhfsClass;
	}

	public String getNewAhfsClass() {
		return newAhfsClass;
	}

	public void setNewAhfsClass(String newAhfsClass) {
		this.newAhfsClass = newAhfsClass;
	}

	public LocalizedValue getDescription() {
		return description;
	}

	public void setDescription(LocalizedValue description) {
		this.description = description;
	}

	public Long getModificationTransaction() {
		return modificationTransaction;
	}

	public void setModificationTransaction(Long modificationTransaction) {
		this.modificationTransaction = modificationTransaction;
	}

	public Long getCreationTransaction() {
		return creationTransaction;
	}

	public void setCreationTransaction(Long creationTransaction) {
		this.creationTransaction = creationTransaction;
	}

	public String getAliasesEn() {
		return aliasesEn;
	}

	public void setAliasesEn(String aliasesEn) {
		this.aliasesEn = aliasesEn;
	}

	public String getAliasesFr() {
		return aliasesFr;
	}

	public void setAliasesFr(String aliasesFr) {
		this.aliasesFr = aliasesFr;
	}

	public Boolean getComboFlag() {
		return comboFlag;
	}

	public void setComboFlag(Boolean comboFlag) {
		this.comboFlag = comboFlag;
	}

	public Long getSingleIndication() {
		return singleIndication;
	}

	public void setSingleIndication(Long singleIndication) {
		this.singleIndication = singleIndication;
	}

	@Column(name = "COMBO_FLAG", nullable = false)
	private Boolean comboFlag;

	@Column(name = "SINGLE_INDICATION_TERM_ID", nullable = true)
	private Long singleIndication;

	public Codegen() {
	}

}
