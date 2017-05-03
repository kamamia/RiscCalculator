package org.mcgill.risk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "DRUG")
public class Drug {

	@Id
	@Column(name = "ID", nullable = false)
	private Integer id;

	public Codegen getCodegen() {
		return codegen;
	}

	public void setCodegen(Codegen codegen) {
		this.codegen = codegen;
	}

	public Integer getStrengthNumeric() {
		return strengthNumeric;
	}

	public void setStrengthNumeric(Integer strengthNumeric) {
		this.strengthNumeric = strengthNumeric;
	}

	public LocalizedValue getStrength() {
		return strength;
	}

	public void setStrength(LocalizedValue strength) {
		this.strength = strength;
	}

	public LocalizedValue getTrademarkName() {
		return trademarkName;
	}

	public void setTrademarkName(LocalizedValue trademarkName) {
		this.trademarkName = trademarkName;
	}

	public LocalizedValue getDefaultInstructions() {
		return defaultInstructions;
	}

	public void setDefaultInstructions(LocalizedValue defaultInstructions) {
		this.defaultInstructions = defaultInstructions;
	}

	public LocalizedValue getDefaultFreetextPosology() {
		return defaultFreetextPosology;
	}

	public void setDefaultFreetextPosology(
			LocalizedValue defaultFreetextPosology) {
		this.defaultFreetextPosology = defaultFreetextPosology;
	}

	public LocalizedValue getStrengthUnits() {
		return strengthUnits;
	}

	public void setStrengthUnits(LocalizedValue strengthUnits) {
		this.strengthUnits = strengthUnits;
	}

	public LocalizedValue getDefaultRoute() {
		return defaultRoute;
	}

	public void setDefaultRoute(LocalizedValue defaultRoute) {
		this.defaultRoute = defaultRoute;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "DIN", nullable = false)
	private String din;

	@Column(name = "MONOGRAPH_NO", nullable = true)
	private String monographno;

	@Column(name = "STRENGTH", nullable = true)
	private Integer strengthNumeric;

	@Column(name = "DRUG_FORMAT_ID", nullable = false)
	private Integer drugformatid;

	@Column(name = "DRUG_LEGAL_STATUS_ID", nullable = true)
	private Integer druglegalstatus;

	@Column(name = "DISCONTINUED_FLAG", nullable = false)
	private Integer discontinuedflag;

	@Column(name = "DEFAULT_QUANTITY_BY_FORMAT", nullable = true)
	private Integer defaultquantitybyformat;

	@Column(name = "DEFAULT_DURATION_DAYS", nullable = true)
	private Integer defaultdurationdays;

	@Column(name = "DEFAULT_MULTIPLIER", nullable = true)
	private Integer defaultmultiplier;

	@Column(name = "DEFAULT_DRUG_FREQUENCY_ID", nullable = true)
	private Integer drugfrequencyid;

	@Column(name = "DEFAULT_REFILLS", nullable = true)
	private Integer defaultrefils;

	@Column(name = "CREATION_TRANSACTION_ID", nullable = true)
	private Integer creationtransactionid;

	@Column(name = "MODIFICATION_TRANSACTION_ID", nullable = true)
	private Integer modificationtransactionid;

	@Column(name = "UNIT_COST", nullable = true)
	private Integer unitcost;

	@Column(name = "TYPICAL_DAILY_DOSE", nullable = true)
	private Integer typicaldailydose;

	@Column(name = "RAMQ_MONOGRAPH_NO", nullable = true)
	private String ramqmonographno;

	@Column(name = "IMAGE_FILE_NAME", nullable = true)
	private String imagefilename;

	@ManyToOne
	@JoinColumn(name = "CODEGEN_ID")
	private Codegen codegen;

	@ManyToOne
	@JoinColumn(name = "STRENGTH_LVID")
	private LocalizedValue strength;

	@ManyToOne
	@JoinColumn(name = "TRADEMARK_NAME_LVID")
	private LocalizedValue trademarkName;

	@ManyToOne
	@JoinColumn(name = "DEFAULT_INSTRUCTIONS_LVID")
	private LocalizedValue defaultInstructions;

	@ManyToOne
	@JoinColumn(name = "DEFAULT_FREETEXT_POSOLOGY_LVID")
	private LocalizedValue defaultFreetextPosology;

	@ManyToOne
	@JoinColumn(name = "STRENGTH_UNITS_LVID")
	private LocalizedValue strengthUnits;

	@ManyToOne
	@JoinColumn(name = "DEFAULT_ROUTE_LVID")
	private LocalizedValue defaultRoute;

	@Transient
	private boolean isTripp;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDin() {
		return din;
	}

	public void setDin(String din) {
		this.din = din;
	}

	public boolean isTripp() {
		return isTripp;
	}

	public void setTripp(boolean isTripp) {
		this.isTripp = isTripp;
	}

	public String getMonographno() {
		return monographno;
	}

	public void setMonographno(String monographno) {
		this.monographno = monographno;
	}

	public Integer getDrugformatid() {
		return drugformatid;
	}

	public void setDrugformatid(Integer drugformatid) {
		this.drugformatid = drugformatid;
	}

	public Integer getDruglegalstatus() {
		return druglegalstatus;
	}

	public void setDruglegalstatus(Integer druglegalstatus) {
		this.druglegalstatus = druglegalstatus;
	}

	public Integer getDiscontinuedflag() {
		return discontinuedflag;
	}

	public void setDiscontinuedflag(Integer discontinuedflag) {
		this.discontinuedflag = discontinuedflag;
	}

	public Integer getDefaultquantitybyformat() {
		return defaultquantitybyformat;
	}

	public void setDefaultquantitybyformat(Integer defaultquantitybyformat) {
		this.defaultquantitybyformat = defaultquantitybyformat;
	}

	public Integer getDefaultdurationdays() {
		return defaultdurationdays;
	}

	public void setDefaultdurationdays(Integer defaultdurationdays) {
		this.defaultdurationdays = defaultdurationdays;
	}

	public Integer getDefaultmultiplier() {
		return defaultmultiplier;
	}

	public void setDefaultmultiplier(Integer defaultmultiplier) {
		this.defaultmultiplier = defaultmultiplier;
	}

	public Integer getDrugfrequencyid() {
		return drugfrequencyid;
	}

	public void setDrugfrequencyid(Integer drugfrequencyid) {
		this.drugfrequencyid = drugfrequencyid;
	}

	public Integer getDefaultrefils() {
		return defaultrefils;
	}

	public void setDefaultrefils(Integer defaultrefils) {
		this.defaultrefils = defaultrefils;
	}

	public Integer getCreationtransactionid() {
		return creationtransactionid;
	}

	public void setCreationtransactionid(Integer creationtransactionid) {
		this.creationtransactionid = creationtransactionid;
	}

	public Integer getModificationtransactionid() {
		return modificationtransactionid;
	}

	public void setModificationtransactionid(Integer modificationtransactionid) {
		this.modificationtransactionid = modificationtransactionid;
	}

	public Integer getUnitcost() {
		return unitcost;
	}

	public void setUnitcost(Integer unitcost) {
		this.unitcost = unitcost;
	}

	public Integer getTypicaldailydose() {
		return typicaldailydose;
	}

	public void setTypicaldailydose(Integer typicaldailydose) {
		this.typicaldailydose = typicaldailydose;
	}

	public String getRamqmonographno() {
		return ramqmonographno;
	}

	public void setRamqmonographno(String ramqmonographno) {
		this.ramqmonographno = ramqmonographno;
	}

	public String getImagefilename() {
		return imagefilename;
	}

	public void setImagefilename(String imagefilename) {
		this.imagefilename = imagefilename;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((this.din == null) ? 0 : this.din.hashCode());
		result = prime
				* result
				+ ((this.monographno == null) ? 0 : this.monographno.hashCode());
		result = prime
				* result
				+ ((this.ramqmonographno == null) ? 0 : this.ramqmonographno
						.hashCode());
		result = prime
				* result
				+ ((this.imagefilename == null) ? 0 : this.imagefilename
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Drug))
			return false;
		Drug other = (Drug) obj;

		if (this.din == null) {
			if (other.din != null)
				return false;
		} else if (!this.din.equals(other.din))
			return false;
		return true;
	}

	@Override
	public String toString() {

		return "Drug [id-dd=" + id + ", localizedvalue--dd="
				+ this.trademarkName.getDescriptionEn() + ", din=" + this.din
				+ ", imagefilename="

				+ this.imagefilename + ", monographno=" + this.monographno
				+ ", ramqmonographno=" + this.ramqmonographno + ", codegen="
				+ this.codegen +
				", creationtransactionid=" + this.creationtransactionid
				+ ", defaultdurationdays=" + this.defaultdurationdays
				+ ", defaultfreetextposologylvid="
				+ ", defaultinstructionslvid=" + ", defaultmultiplier="
				+ this.defaultmultiplier + ", defaultquantitybyformat="
				+ this.defaultquantitybyformat + ", defaultrefils="
				+ this.defaultrefils + ", defaultroutelvid="
				+ ", discontinuedflag=" + this.discontinuedflag
				+ ", drugformatid=" + this.drugformatid +

				", drugfrequencyid=" + this.drugfrequencyid
				+ ", druglegalstatus=" + this.druglegalstatus
				+ ", modificationtransactionid="
				+ this.modificationtransactionid + ", strength="
				+ this.strength +

				", unitcost=" + this.unitcost +

				"]";
	}

}
