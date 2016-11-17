package model;

public class SubmitProblem implements java.io.Serializable{
	
	private int submitid;
	private int problemsid;
	private int submituser;
	private String codetext;
	public int getSubmitid() {
		return submitid;
	}
	public void setSubmitid(int submitid) {
		this.submitid = submitid;
	}
	public int getProblemsid() {
		return problemsid;
	}
	public void setProblemsid(int problemsid) {
		this.problemsid = problemsid;
	}
	public int getSubmituser() {
		return submituser;
	}
	public void setSubmituser(int submituser) {
		this.submituser = submituser;
	}
	public String getCodetext() {
		return codetext;
	}
	public void setCodetext(String codetext) {
		this.codetext = codetext;
	}
	
	
	
}
