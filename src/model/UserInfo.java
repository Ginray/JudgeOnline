package model;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String username;
	private String password;
	private String nickname;
	private String email;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	public UserInfo(int uid ,String username, String password, String nickname,String email) {
		this.uid=uid;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.email    = email;
	}
	
	/** minimal constructor */
	public UserInfo(String username, String password, String nickname) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;
	}

	/** full constructor */
	public UserInfo(String username, String password, String nickname,
			String email) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}