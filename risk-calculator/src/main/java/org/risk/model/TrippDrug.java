package org.risk.model;

import org.mcgill.risk.spring.model.Drug;
import java.math.BigDecimal;

public final class TrippDrug {

	private final String din;
	private final String codegen;
	private final BigDecimal quantity;
	private final Integer duration;
	private  BigDecimal tdd;

	
	private  Drug drug;  
	
	public TrippDrug()
	{
		
		this.din = "";
		this.codegen = "";
		quantity= new BigDecimal(0);
		duration= 0;
	}
	
	public TrippDrug(String din,String codegen, BigDecimal quantity, Integer duration) {

this.din = din;
this.codegen = ""+codegen;




if (quantity == null || duration == null) {
	this.quantity = null;
	this.duration = null;
} else {
	this.quantity = quantity; 
	this.duration = duration;
}
}
	
	
	public TrippDrug(Drug drug,
					 //String din,String codegen, // options Hicham
					 BigDecimal quantity, Integer duration) {
		// next two can be cut out   (we have Drug now)
		this.din = drug.getDin();
		this.codegen = ""+drug.getCodegen();

		
		this.drug = drug;

		
		if (quantity == null || duration == null) {
			this.quantity = null;
			this.duration = null;
		} else {
			this.quantity = quantity; 
			this.duration = duration;
		}
	}

	public Drug getDrug() {
		return drug;
	}

	/**
	 * returns quantity
	 * <p/>
	 * Use bd.getPlainString() if you need a string representation
	 *
	 * @return quantity
	 */
	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public String getDin() {
		return din;
	}

	public String getCodegen() {
		return codegen;
	}

	@Override
	public String toString()
	{
		
		
		return "TrippDrug=: [ din="+this.getDin()+" quantity="+getQuantity()+" duration="+getDuration()+" codegen="+getCodegen()+"]";
		
	}

	public BigDecimal getTdd() {
		return tdd;
	}
	
	
}
