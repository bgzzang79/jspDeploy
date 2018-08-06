package kr.or.ddit.cookie.util;

public class CookieUtil {

	/**
	 * Method : getCookie
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param cookie
	 * @param string
	 * @return
	 * Method 설명 : 쿠키 조회
	 */
	public String getCookie(String cookie, String name) {
//		userId=brown; name=kang
//		String[] cookies = cookie.split("; ");
//		String result = "";
//		for (int i = 0; i < cookies.length; i++) {
//			String[] cookieValue = cookies[i].split("=");
//			for (int j = 0; j < cookieValue.length; j++) {
//				if(j%2==1){
//					result =  cookieValue[j];
//					break;
//				}
//			}
//			break;
//		}
//		return result;
		String[] cookies = cookie.split("; ");
		String cookieResult = "";
		for (String cookieStr : cookies) {
			String[] cookieNameValue = cookieStr.split("=");
			
			String cookieName = cookieNameValue[0];
			String cookieValue = cookieNameValue[1];
			
			if(name.equals(cookieName)){
				cookieResult = cookieValue;
				break;
			}
		}
		return cookieResult;
	}

}
