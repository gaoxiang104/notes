package org.xgo.learn.servlet.controller.work03;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAgentParser {
    public UserAgentParser() {
    }

    public static Map<String, String> parseUserAgent(String userAgent) {
        Map<String, String> userAgentInfo = new HashMap<>();

        Pattern pattern = Pattern.compile("(.+?) \\((.+?)\\) (.+)");
        Matcher matcher = pattern.matcher(userAgent);

        if (matcher.matches()) {
            String osInfo = matcher.group(2);
            String[] osParts = osInfo.split(";");

            userAgentInfo.put("Browser", matcher.group(3));
            userAgentInfo.put("Version", matcher.group(1));
            userAgentInfo.put("OS", osParts[0].trim());

            if (osParts.length > 1) {
                userAgentInfo.put("OS Version", osParts[1].trim());
            }
        }

        return userAgentInfo;
    }

    public static void main(String[] args) {
        String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36";

        Map<String, String> info = parseUserAgent(userAgent);
        for (Map.Entry<String, String> entry : info.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

