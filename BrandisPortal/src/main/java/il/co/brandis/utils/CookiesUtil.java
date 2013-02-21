package il.co.brandis.utils;

import il.co.brandis.entities.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtil {
	// Cookies Times
	public static int TWELEVE_HOURS = 43200;
	public static int EXPIRED = 0;

	// Cookies names
	public static String USER_COOKIE_NAME = "user_d_cookie";

	public static void userCookieCreation(HttpServletRequest req,
			HttpServletResponse res, User user) {
		Cookie[] cookies = req.getCookies();
		Cookie cookie = null;
		for (Cookie c : cookies) {
			if (isUserCookie(c))
				cookie = c;
		}
		if (cookie != null) {
			cookie.setPath("/");
			cookie.setMaxAge(TWELEVE_HOURS);
			res.addCookie(cookie);
		} else {
			cookie = new Cookie(USER_COOKIE_NAME, Integer.toString(user
					.getuId()));
			cookie.setMaxAge(TWELEVE_HOURS);
			cookie.setPath("/");
			res.addCookie(cookie);
		}
	}

	public static Cookie getUserCookie(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (isUserCookie(c)) {
					return c;
				}
			}
		}
		return null;
	}

	private static boolean isUserCookie(Cookie c) {

		return USER_COOKIE_NAME.equals(c.getName());
	}

	public static void removeUserCookie(HttpServletResponse res, Cookie cookie) {
		cookie.setPath("/");
		cookie.setMaxAge(EXPIRED);
		res.addCookie(cookie);
	}
}
