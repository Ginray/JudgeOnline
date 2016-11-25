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
	private Integer problemId;
	private Integer userId;
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
	public Submitstate(Integer problemId, Integer userId, Date submitDate) {
		this.problemId = problemId;
		this.userId = userId;
		this.submitDate = submitDate;
	}

	/** full constructor */
	public Submitstate(Integer problemId, Integer userId, String state,
			String codeType, String memory, String runtime, Date submitDate,
			Integer codeLength) {
		this.problemId = problemId;
		this.userId = userId;
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

	@Column(name = "problem_id", nullable = false)
	public Integer getProblemId() {
		return this.problemId;
	}

	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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