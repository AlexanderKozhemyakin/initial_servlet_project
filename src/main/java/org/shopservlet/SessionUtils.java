package org.shopservlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class SessionUtils {
    public static String generateRandomBase64TokenSessionId(int byteLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[byteLength];
        secureRandom.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token);
    }

    public static String handleUrlFromRequest(HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
        HttpSession session = request.getSession(false);

        String query = Optional.ofNullable(request.getQueryString()).orElse("");
        String url = request.getServletPath() + (query.isEmpty() ? "" : "?" + query);
        String sessionId = getSessionIdFromUrl(url);

        if (sessionId.isEmpty()) {
            session = request.getSession();
            final String newSessionId = SqlExecutions.generateAndSaveInDbNewSessionId();
            url = addSessionIdToUrl(url, newSessionId);
            session.setAttribute("sessionId", newSessionId);
        }else{
            session.setAttribute("sessionId", sessionId);
        }
        return url;
    }
    public static String addSessionIdToUrl(String url, String sessionId){
        if (url.contains("sessionId=")){
           return url;
        }
        String returnUrl ="";
        if (url.endsWith("?")){
                returnUrl = url + "sessionId=" + sessionId;
            } else if (url.endsWith("/")) {
                returnUrl = url + "main?sessionId=" + sessionId;
            } else {
                if (url.endsWith("&")){
                    returnUrl = url + "sessionId="+sessionId;
                } else if (url.contains("?")){
                    returnUrl = url + "&" + "sessionId="+sessionId;
                } else {
                    returnUrl = url + "?" + "sessionId="+sessionId;
                }
        }
        return returnUrl;
    }

    public static String getParameterValueFromUrl(String queryString, String parameterName) throws UnsupportedEncodingException {
        String returnParameterValue="";
        final List<NameValuePair> params =
                URLEncodedUtils.parse(queryString, StandardCharsets.UTF_8);
        for (final NameValuePair param : params) {
            if (parameterName.equals(param.getName())){
                returnParameterValue = param.getValue();
            }
        }
        return returnParameterValue;
    }

    public static String getSessionIdFromUrl(String url) throws UnsupportedEncodingException {
        return getParameterValueFromUrl(url, "sessionId");
    }
    public static String getUserNameFromUrl(String url) throws UnsupportedEncodingException {
        return getParameterValueFromUrl(url, "username");
    }
}
