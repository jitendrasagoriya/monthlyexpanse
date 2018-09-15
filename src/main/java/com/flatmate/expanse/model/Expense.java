/**
 * 
 */
package com.flatmate.expanse.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.flatmate.expanse.enums.ExpenseType;

/**
 * @author jitendra Sagroiya
 *
 */
@Entity
@Table(name="EXPENCES")
public class Expense implements Serializable {
 
	private static final long serialVersionUID = 4726520257020990194L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="TYPE")
	@NotNull
	private ExpenseType expenseType;
	
	@Column(name="AMOUNT")
	@NotNull
	private Float amount;
	
	@Column(name="EXPENSEDATE") 
	private Timestamp expanseDate;
	
	@Column(name="DESCRIPTION") 
	private String description;
	
	@Column(name="FID")
	@NotNull
	private Long flatMateId;

	/**
	 * 
	 */
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param expenseType
	 * @param amount
	 * @param expanseDate
	 * @param description
	 * @param flatMateId
	 */
	public Expense(Long id, @NotNull ExpenseType expenseType, @NotNull Float amount, Timestamp expanseDate,
			String description, @NotNull Long flatMateId) {
		super();
		this.id = id;
		this.expenseType = expenseType;
		this.amount = amount;
		this.expanseDate = expanseDate;
		this.description = description;
		this.flatMateId = flatMateId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExpenseType getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(ExpenseType expenseType) {
		this.expenseType = expenseType;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Timestamp getExpanseDate() {
		return expanseDate;
	}

	public void setExpanseDate(Timestamp expanseDate) {
		this.expanseDate = expanseDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getFlatMateId() {
		return flatMateId;
	}

	public void setFlatMateId(Long flatMateId) {
		this.flatMateId = flatMateId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((expanseDate == null) ? 0 : expanseDate.hashCode());
		result = prime * result + ((expenseType == null) ? 0 : expenseType.hashCode());
		result = prime * result + ((flatMateId == null) ? 0 : flatMateId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expense other = (Expense) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (expanseDate == null) {
			if (other.expanseDate != null)
				return false;
		} else if (!expanseDate.equals(other.expanseDate))
			return false;
		if (expenseType != other.expenseType)
			return false;
		if (flatMateId == null) {
			if (other.flatMateId != null)
				return false;
		} else if (!flatMateId.equals(other.flatMateId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", expenseType=" + expenseType + ", amount=" + amount + ", expanseDate="
				+ expanseDate + ", description=" + description + ", flatMateId=" + flatMateId + "]";
	}
	
	
}
