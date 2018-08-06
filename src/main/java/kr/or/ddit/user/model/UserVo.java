package kr.or.ddit.user.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserVo implements HttpSessionBindingListener {
	private Logger logger = LoggerFactory.getLogger(UserVo.class);
	
	private String userId;
	private String userPw;
	private String userNm;
	
	public UserVo() {
		
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	public boolean validateUser(String userId, String userPw){
		if(this.getUserId().equals(userId) && this.getUserPw().equals(userPw)){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", userPw=" + userPw + ", userNm="
				+ userNm + "]";
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		//session객체에서 session.setAttribute("userVo",userVo)가 호출 되었을때
		logger.debug("httpSessionBinding valueBound : "+event.getName());
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		//session객체에서 session.removeAttribute("userVo)가 호출 되었을때		
		logger.debug("httpSessionUnbinding valueUnBound : "+event.getName());
	}
}