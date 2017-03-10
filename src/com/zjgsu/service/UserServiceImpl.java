package com.zjgsu.service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import model.Problem;
import model.UserInfo;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.python.antlr.ast.keyword;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjgsu.utils.HibernateSessionFactory;
import org.springframework.util.DigestUtils;

import static javafx.scene.input.KeyCode.R;
import static org.apache.struts2.ServletActionContext.getResponse;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    /*Spring和Hibernate整个后*/
    private SessionFactory sessionFactory; //定义一个sessionFactory  

    //当需要使用sessoinFactory的时候，Spring会将sessionFactory注入进来  

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        //从当前线程获取session，如果没有则创建一个新的session  
        return sessionFactory.getCurrentSession();
    }

    @Override
    public String login(UserInfo userinfo) {

        try {
            String sql = "select * from user_info where username= ? and password=? ";
            String test = "select * from user_info where username= "+userinfo.getUsername()+" and password="+userinfo.getPassword();
            System.out.println(test);
            Query query = getSession().createSQLQuery(sql).addEntity(UserInfo.class);
            query.setString(0, userinfo.getUsername());
            query.setString(1, userinfo.getPassword());
            List<UserInfo> li = query.list();
            //List<UserInfo> list= getSession().createQuery("from UserInfo as user where user.username=:userinfo.username and user.password=:userinfo.password").list();
            System.out.println("----list number " + li.size());
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            String to_URL = (String) session.getAttribute("re_URL");
            HttpServletResponse response = ServletActionContext.getResponse();
            if (li.size() > 0) {
                //cookie保存时，如果用户名或密码有汉字或者其他特殊字符需要进行编码
                //Cookie c1=new Cookie("username",URLEncoder.encode(userinfo.getUsername(),"UTF-8"));
                //Cookie c2=new Cookie("password",userinfo.getPassword());
                //c1.setMaxAge(3600);
                //c2.setMaxAge(3600);
                //HttpServletResponse response=ServletActionContext.getResponse();

                //response.addCookie(c1);
                //response.addCookie(c2);

                request.getSession().setAttribute("userid", li.get(0).getUid());
                request.getSession().setAttribute("username", li.get(0).getUsername());
                request.getSession().setAttribute("password", li.get(0).getPassword());
                request.getSession().setAttribute("nickname", li.get(0).getNickname());
                request.getSession().setAttribute("email", li.get(0).getEmail());
                if(li.get(0).getEmail()!=null){
                    String MD5= DigestUtils.md5DigestAsHex(li.get(0).getEmail().getBytes());
                    System.out.println("MD5"+MD5);
                    request.getSession().setAttribute("MD5", MD5);
                }else{
                    request.getSession().setAttribute("MD5", "d4c74594d84113932869575bdrdt6");
                }
                ServletContext app = request.getServletContext();
                ArrayList<String> loginList = (ArrayList<String>) app.getAttribute("loginlist");
                if (loginList == null) {
                    loginList = new ArrayList<String>();
                    app.setAttribute("loginlist", loginList);
                }
                loginList.add(li.get(0).getNickname());

                if (to_URL != null) {
                    System.out.println("send_URL=" + to_URL);
                    response.sendRedirect(to_URL);
                }
                return "success";
            } else {
                if (to_URL != null) {
                    System.out.println("send_URL=" + to_URL);
                    response.sendRedirect(to_URL);
                }
                return "fail";

            }
            //getSession().delete(userinfo);
            //getSession().save(userinfo);
            //getSession().update(userinfo);
        } catch (Exception e) {
            System.out.println("UserServiceImpl login时发生错误" + e);
            return "fail";
        }
    }

    @Override
    public String register(UserInfo userinfo) {

        try {
            String sql = "select * from user_info where username= ? and password=? ";
            Query query = getSession().createSQLQuery(sql).addEntity(UserInfo.class);
            query.setString(0, userinfo.getUsername());
            query.setString(1, userinfo.getPassword());
            List<UserInfo> li = query.list();
            HttpServletRequest request= ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            String to_URL = (String) session.getAttribute("re_URL");
            HttpServletResponse response = ServletActionContext.getResponse();
            if (li.size() > 0) {
                if (to_URL != null) {
                    System.out.println("send_URL=" + to_URL);
                    response.sendRedirect(to_URL);
                }
                return "fail";
            } else {
                getSession().save(userinfo);
                request.getSession().setAttribute("username", userinfo.getUsername());
                request.getSession().setAttribute("nickname", userinfo.getNickname());
                request.getSession().setAttribute("email", userinfo.getEmail());
                request.getSession().setAttribute("password", userinfo.getPassword());
                if (to_URL != null) {
                    System.out.println("send_URL=" + to_URL);
                    response.sendRedirect(to_URL);
                }
                return "success";
            }
        } catch (Exception e) {
            System.out.println("UserServiceImpl register时发生错误" + e);
            return "fail";
        }
    }


    @Override
    public void logout(UserInfo userinfo) {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            ServletContext app = request.getServletContext();
            ArrayList<String> loginList = (ArrayList<String>) app.getAttribute("loginlist");
            if (loginList != null) {
                System.out.println(session.getAttribute("nickname"));
                loginList.remove(session.getAttribute("nickname"));
            }
            session.removeAttribute("userid");
            session.removeAttribute("username");
            session.removeAttribute("password");
            session.removeAttribute("nickname");
            session.removeAttribute("email");
            String to_URL = (String) session.getAttribute("re_URL");
            HttpServletResponse response = ServletActionContext.getResponse();

            if (to_URL != null) {
                System.out.println("send_URL=" + to_URL);
                response.sendRedirect(to_URL);
            }
        } catch (Exception e) {
            System.out.println("UserServiceImpl logout时发生错误" + e);
        }
    }


    @Override
    public void modify(UserInfo userinfo) {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            String sessionname = (String) request.getSession().getAttribute("username");
            userinfo.setUsername(sessionname);
            String sql = "select * from user_info where username= ? and password=? ";
            Query query = getSession().createSQLQuery(sql).addEntity(UserInfo.class);
            query.setString(0, userinfo.getUsername());
            query.setString(1, userinfo.getPassword());
            List<UserInfo> li = query.list();
            HttpSession session = request.getSession();
            String to_URL = (String) session.getAttribute("re_URL");
            HttpServletResponse response = ServletActionContext.getResponse();
            if (li.size() > 0) {
                userinfo.setUid(li.get(0).getUid());
                request.getSession().setAttribute("nickname", userinfo.getNickname());
                request.getSession().setAttribute("email", userinfo.getEmail());
                request.getSession().setAttribute("password", userinfo.getPassword());
                getSession().merge(userinfo);
                getSession().update(userinfo);
                if (to_URL != null) {
                    System.out.println("send_URL=" + to_URL);
                    response.sendRedirect(to_URL);
                }
            } else {
                if (to_URL != null) {
                    System.out.println("send_URL=" + to_URL);
                    response.sendRedirect(to_URL);
                }
                return;
            }

        } catch (Exception e) {
            System.out.println("UserServiceImpl modify时发生错误" + e);
        }
    }

    @Override
    public List<UserInfo> getUser() {
        String sql = "select * from user_info order by accept desc";
        Session s = HibernateSessionFactory.getSession();
        Query query = s.createSQLQuery(sql).addEntity(UserInfo.class);
        List<UserInfo> li = query.list();
        if (li.size() > 0) {
            return li;
        } else {
            System.out.println("UserServiceImpl getUser时出错");
            return null;
        }
    }

    @Override
    public List<UserInfo> searchRanklist(String keyword) {
        String sql = "select * from user_info where username like" + "'%" + keyword + "%' " + "or nickname like" + "'%" + keyword + "%' ";
        Session s = HibernateSessionFactory.getSession();
        Query query = s.createSQLQuery(sql).addEntity(UserInfo.class);
        List<UserInfo> li = query.list();
        if (li.size() > 0) {
            return li;
        } else {
            System.out.println("ProblemServiceImpl searchRanklist未找到对应user");
            return null;
        }
    }

}
