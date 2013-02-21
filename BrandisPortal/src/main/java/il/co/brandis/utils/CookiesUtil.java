package il.co.brandis.utils;

import il.co.brandis.entities.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class CookiesUtil {
	//Cookies Times
	public static int TWELEVE_HOURS = 43200;
	public static int EXPIRED = 0;
	
	
	//Cookies names
	public static String USER_COOKIE_NAME = "user_d_cookie";
	//Cookies domains
	public static String USER_COOKIE_DOMAIN = "user.brandis.co.il";
	
	//Cookies paths
	public static String USER_COOKIE_PATH = "/cookies/users";
	
	public static void userCookieCreation(HttpServletRequest req, HttpServletResponse res, User user) {
		Cookie[] cookies = req.getCookies();
		Cookie cookie = null;
		for (Cookie c: cookies) {
			if (isUserCookie(c))
				cookie = c;
		}
		if (cookie != null) {
			cookie.setMaxAge(TWELEVE_HOURS);
			cookie.setDomain(USER_COOKIE_DOMAIN);
			cookie.setPath(USER_COOKIE_PATH);
			res.addCookie(cookie);
		} else {
			cookie = new Cookie(USER_COOKIE_NAME, Integer.toString(user.getuId()));
			cookie.setMaxAge(TWELEVE_HOURS);
			cookie.setDomain(USER_COOKIE_DOMAIN);
			cookie.setPath(USER_COOKIE_PATH);
			res.addCookie(cookie);
		}
		
	}

	public static Cookie getUserCookie(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		for (Cookie c: cookies) {
			if (isUserCookie(c)) {
				return c;
			}
		}
		return null;
	}

	private static boolean isUserCookie(Cookie c) {
		return USER_COOKIE_NAME.equals(c.getName()) && 
					USER_COOKIE_DOMAIN.equals(c.getDomain()) && 
						USER_COOKIE_PATH.equals(c.getPath());
	}

	public static void removeUserCookie(HttpServletResponse res, Cookie cookie) {
		cookie.setDomain(USER_COOKIE_DOMAIN);
		cookie.setPath(USER_COOKIE_PATH);
		cookie.setMaxAge(EXPIRED);	
		res.addCookie(cookie);
	}
}
