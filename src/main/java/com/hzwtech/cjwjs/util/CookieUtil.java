//package com.hzwtech.cjwjs.util;
//
//import org.apache.commons.codec.binary.Hex;
//import org.springframework.util.SerializationUtils;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.Serializable;
//
///**
// * @author Jasper Liuzengyu 刘增玉
// * @version v1.0.0
// * @description
// * @date 2021/6/2
// * @since v1.0
// */
//public class CookieUtil {
//
//
//    /**
//     * 根据Cookie名称得到Cookie的值，没有返回Null
//     *
//     * @param request
//     * @param name
//     * @return
//     */
//    public static String getCookieValue(HttpServletRequest request, String name) {
//        Cookie cookie = getCookie(request, name);
//        if (cookie != null) {
//            return cookie.getValue();
//        } else {
//            return null;
//        }
//    }
//
//    /**
//     * 根据Cookie名称得到Cookie对象，不存在该对象则返回Null
//     *
//     * @param request
//     * @param name
//     * @return
//     */
//    public static Cookie getCookie(HttpServletRequest request, String name) {
//        Cookie cookies[] = request.getCookies();
//        if (cookies == null || name == null || name.length() == 0) {
//            return null;
//        }
//
//        Cookie cookie = null;
//        for (int i = 0; i < cookies.length; i++) {
//            if (!cookies[i].getName().equals(name)) {
//                continue;
//            }
//
//            cookie = cookies[i];
//            if (request.getServerName().equals(cookie.getDomain())) {
//                break;
//            }
//        }
//
//        return cookie;
//    }
//
//    /**
//     * 删除指定Cookie
//     *
//     * @param response
//     * @param cookie
//     */
//    public static void deleteCookie(HttpServletResponse response, Cookie cookie) {
//        if (cookie != null) {
//            cookie.setPath("/");
//            cookie.setValue("");
//            cookie.setMaxAge(0);
//            response.addCookie(cookie);
//        }
//    }
//
//    /**
//     * 删除指定Cookie
//     *
//     * @param response
//     * @param cookie
//     */
//    public static void deleteCookie(HttpServletResponse response, Cookie cookie, String domain) {
//        if (cookie != null) {
//            cookie.setPath("/");
//            cookie.setValue("");
//            cookie.setMaxAge(0);
//            cookie.setDomain(domain);
//            response.addCookie(cookie);
//        }
//    }
//
//    /**
//     * 添加一条新的Cookie信息，默认有效时间为一个月
//     *
//     * @param response
//     * @param name
//     * @param value
//     */
//    public static void setCookie(HttpServletResponse response, String name, String value) {
//        setCookie(response, name, value, 0x278d00);
//    }
//
//    /**
//     * 添加一条新的Cookie信息，可以设置其最长有效时间(单位：秒)
//     *
//     * @param response
//     * @param name
//     * @param value
//     * @param maxAge
//     */
//    public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
//        if (value == null) {
//            value = "";
//        }
//
//        Cookie cookie = new Cookie(name, value);
//        cookie.setMaxAge(maxAge);
//        cookie.setPath("/");
//        response.addCookie(cookie);
//    }
//
//    /**
//     * 添加一条新的Cookie信息，可以设置其Name，Value，MaxAge，Path，Domain(单位：秒)
//     *
//     * @param response
//     * @param name
//     * @param value
//     * @param maxAge
//     */
//    public static void setCookie(HttpServletResponse response, String name, String value, int maxAge, String path, String domain) {
//        if (value == null) {
//            value = "";
//        }
//
//        Cookie cookie = new Cookie(name, value);
//        cookie.setMaxAge(maxAge);
//        cookie.setPath(path);
//        cookie.setDomain(domain);
//        response.addCookie(cookie);
//    }
//
//    public static void setCookie(HttpServletResponse response, Serializable serializable) {
//        try {
//            byte[] serializableBytes = SerializationUtils.serialize(serializable);
//            String value = String.valueOf(Hex.encodeHex(SecurityUtil.encryptDES(serializableBytes, Constant.LOGIN_SECRET_KEY)));
//            String ticket = KeyGenerator.getUUID();
//            // 一天过期
//            //redisCacheUtil.set(ticket, value, 1, TimeUnit.DAYS);
//            setCookie(response, EncryptUtil.getMD5String(DateUtil.getCurrentDate("yyyy-MM-dd")), ticket, -1);
//        } catch (Exception e) {
//        }
//    }
//
//    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response) {
//        String ticket = null;
//        try {
//            ticket = getCookieValue(request, EncryptUtil.getMD5String(DateUtil.getCurrentDate("yyyy-MM-dd")));
//            // 从缓存删除ticket
//            //redisCacheUtil.delete(ticket);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        try {
//            deleteCookie(response, new Cookie(EncryptUtil.getMD5String(DateUtil.getCurrentDate("yyyy-MM-dd")), null));
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * 获取所有的cookie
//     *
//     * @return
//     */
//    public static Cookie[] getCookies() {
//        HttpServletRequest request = getRequest();
//        if (request == null) {
//            return null;
//        }
//        Cookie[] cookies = request.getCookies();
//        if (cookies == null || cookies.length == 0) {
//            return null;
//        }
//        return cookies;
//    }
//
//
//    /**
//     * 获取请求中的{@link HttpServletRequest}
//     */
//    public static HttpServletRequest getRequest() {
//        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//    }
//
//    /**
//     * 获取{@link HttpServletResponse}
//     */
//    public static HttpServletResponse getResponse() {
//        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
//    }
//}
