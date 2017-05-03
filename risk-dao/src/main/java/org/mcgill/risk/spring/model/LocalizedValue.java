package org.mcgill.risk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCALIZED_VALUE")
public class LocalizedValue {

	@Id
	@Column(name = "ID", nullable = false)
	private Integer id;

	@Column(name = "BUSINESS_ID", nullable = false)
	private String businessId;

	@Column(name = "CODE_TYPE", nullable = false)
	private String codeType;

	@Column(name = "DESCRIPTION_EN", nullable = false)
	private String descriptionEn;

	@Column(name = "DESCRIPTION_FR", nullable = false)
	private String descriptionFr;

	@Column(name = "STATUS", nullable = false)
	private String status;

	@Column(name = "CREATION_TRANSACTION_ID", nullable = true)
	private Integer creationtrid;

	@Column(name = "MODIFICATION_TRANSACTION_ID", nullable = true)
	private Integer modificationtrid;

	@Column(name = "SEQ", nullable = false)
	private Integer sequence;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((this.businessId == null) ? 0 : this.businessId.hashCode());
		result = prime * result
				+ ((this.codeType == null) ? 0 : this.codeType.hashCode());
		result = prime
				* result
				+ ((this.descriptionEn == null) ? 0 : this.descriptionEn
						.hashCode());
		result = prime
				* result
				+ ((this.descriptionFr == null) ? 0 : this.descriptionFr
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LocalizedValue))
			return false;
		LocalizedValue other = (LocalizedValue) obj;
		if (id != other.id && this.businessId != other.businessId)
			return false;

		if (this.codeType == null) {
			if (other.codeType != null)
				return false;
		} else if (!this.codeType.equals(other.codeType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Locale Drug [id=" + id + ", descriptionEn="
				+ this.descriptionEn +

				"]";
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public String getDescriptionFr() {
		return descriptionFr;
	}

	public void setDescriptionFr(String descriptionFr) {
		this.descriptionFr = descriptionFr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getModificationtrid() {
		return modificationtrid;
	}

	public void setModificationtrid(Integer modificationtrid) {
		this.modificationtrid = modificationtrid;
	}

	public Integer getCreationtrid() {
		return creationtrid;
	}

	public void setCreationtrid(Integer creationtrid) {
		this.creationtrid = creationtrid;
	}

}
