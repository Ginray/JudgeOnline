package model;

import javax.persistence.*;

/**
 * Created by Ginray on 2017/2/2.
 */
@Entity
@Table(name = "user_info", schema = "zjgsu_oj")
public class UserInfo {
    private int uid;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Integer submit;
    private Integer accept;

    @Id
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "submit")
    public Integer getSubmit() {
        return submit;
    }

    public void setSubmit(Integer submit) {
        this.submit = submit;
    }

    @Basic
    @Column(name = "accept")
    public Integer getAccept() {
        return accept;
    }

    public void setAccept(Integer accept) {
        this.accept = accept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo that = (UserInfo) o;

        if (uid != that.uid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (submit != null ? !submit.equals(that.submit) : that.submit != null) return false;
        if (accept != null ? !accept.equals(that.accept) : that.accept != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (submit != null ? submit.hashCode() : 0);
        result = 31 * result + (accept != null ? accept.hashCode() : 0);
        return result;
    }
}
