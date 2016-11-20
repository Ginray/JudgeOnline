package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Submitstate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "submitstate", catalog = "zjgsu_oj")
public class Submitstate implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer cid;
	private String state;
	private String codeType;
	private String memory;
	private String runtime;
	private Date submitDate;
	private Integer codeLength;

	// Constructors

	/** default constructor */
	public Submitstate() {
	}

	/** minimal constructor */
	public Submitstate(Integer cid, Date submitDate) {
		this.cid = cid;
		this.submitDate = submitDate;
	}

	/** full constructor */
	public Submitstate(Integer cid, String state, String codeType,
			String memory, String runtime, Date submitDate, Integer codeLength) {
		this.cid = cid;
		this.state = state;
		this.codeType = codeType;
		this.memory = memory;
		this.runtime = runtime;
		this.submitDate = submitDate;
		this.codeLength = codeLength;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "cid", nullable = false)
	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name = "state", length = 20)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "codeType", length = 10)
	public String getCodeType() {
		return this.codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	@Column(name = "memory", length = 20)
	public String getMemory() {
		return this.memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	@Column(name = "runtime", length = 20)
	public String getRuntime() {
		return this.runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "submitDate", nullable = false, length = 0)
	public Date getSubmitDate() {
		return this.submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	@Column(name = "codeLength")
	public Integer getCodeLength() {
		return this.codeLength;
	}

	public void setCodeLength(Integer codeLength) {
		this.codeLength = codeLength;
	}

}