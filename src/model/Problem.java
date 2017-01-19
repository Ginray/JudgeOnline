package model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Problem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "problem", catalog = "zjgsu_oj")
public class Problem implements java.io.Serializable {

	// Fields

	private Integer problemId;
	private String title;
	private String description;
	private String input;
	private String output;
	private String sampleInput;
	private String sampleOutput;
	private String spj;
	private String hint;
	private String source;
	private Timestamp inDate;
	private Integer timeLimit;
	private Integer memoryLimit;
	private String defunct;
	private Integer accepted;
	private Integer submit;
	private Integer solved;

	// Constructors

	/** default constructor */
	public Problem() {
	}

	/** minimal constructor */
	public Problem(String title, String spj, Integer timeLimit,
			Integer memoryLimit, String defunct) {
		this.title = title;
		this.spj = spj;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.defunct = defunct;
	}

	/** full constructor */
	public Problem(String title, String description, String input,
			String output, String sampleInput, String sampleOutput, String spj,
			String hint, String source, Timestamp inDate, Integer timeLimit,
			Integer memoryLimit, String defunct, Integer accepted,
			Integer submit, Integer solved) {
		this.title = title;
		this.description = description;
		this.input = input;
		this.output = output;
		this.sampleInput = sampleInput;
		this.sampleOutput = sampleOutput;
		this.spj = spj;
		this.hint = hint;
		this.source = source;
		this.inDate = inDate;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.defunct = defunct;
		this.accepted = accepted;
		this.submit = submit;
		this.solved = solved;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "problem_id", unique = true, nullable = false)
	public Integer getProblemId() {
		return this.problemId;
	}

	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}

	@Column(name = "title", nullable = false, length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "input", length = 65535)
	public String getInput() {
		return this.input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	@Column(name = "output", length = 65535)
	public String getOutput() {
		return this.output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	@Column(name = "sample_input", length = 65535)
	public String getSampleInput() {
		return this.sampleInput;
	}

	public void setSampleInput(String sampleInput) {
		this.sampleInput = sampleInput;
	}

	@Column(name = "sample_output", length = 65535)
	public String getSampleOutput() {
		return this.sampleOutput;
	}

	public void setSampleOutput(String sampleOutput) {
		this.sampleOutput = sampleOutput;
	}

	@Column(name = "spj", nullable = false, length = 1)
	public String getSpj() {
		return this.spj;
	}

	public void setSpj(String spj) {
		this.spj = spj;
	}

	@Column(name = "hint", length = 65535)
	public String getHint() {
		return this.hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	@Column(name = "source", length = 100)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "in_date", length = 0)
	public Timestamp getInDate() {
		return this.inDate;
	}

	public void setInDate(Timestamp inDate) {
		this.inDate = inDate;
	}

	@Column(name = "time_limit", nullable = false)
	public Integer getTimeLimit() {
		return this.timeLimit;
	}

	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}

	@Column(name = "memory_limit", nullable = false)
	public Integer getMemoryLimit() {
		return this.memoryLimit;
	}

	public void setMemoryLimit(Integer memoryLimit) {
		this.memoryLimit = memoryLimit;
	}

	@Column(name = "defunct", nullable = false, length = 1)
	public String getDefunct() {
		return this.defunct;
	}

	public void setDefunct(String defunct) {
		this.defunct = defunct;
	}

	@Column(name = "accepted")
	public Integer getAccepted() {
		return this.accepted;
	}

	public void setAccepted(Integer accepted) {
		this.accepted = accepted;
	}

	@Column(name = "submit")
	public Integer getSubmit() {
		return this.submit;
	}

	public void setSubmit(Integer submit) {
		this.submit = submit;
	}

	@Column(name = "solved")
	public Integer getSolved() {
		return this.solved;
	}

	public void setSolved(Integer solved) {
		this.solved = solved;
	}

}