package fzu.com.codetop;

public class Solution468 {

    public String validIPAddress(String queryIP) {
        if (isIPv4(queryIP)) {
            return  "IPv4";
        } else if (isIPv6(queryIP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private boolean isIPv4(String ip) {
        if (ip == null || ip.length() == 0) {
            return false;
        }
        if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') {
            return false;
        }
        String[] ips = ip.split("\\.");
        if (ips.length != 4) {
            return false;
        }
        for (String s : ips) {
            if (s.length() == 0 || s.length() > 3 || s.length() > 1 && s.charAt(0) == '0') {
                return false;
            }
            try {
                int num = Integer.parseInt(s);
                if (num > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private boolean isIPv6(String ip) {
        if (ip == null || ip.length() == 0) {
            return false;
        }
        if (ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') {
            return false;
        }
        String[] ips = ip.split(":");
        if (ips.length != 8) {
            return false;
        }
        for (String s : ips) {
            if (s.length() == 0 || s.length() > 4) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                if (!isHexChar(s.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isHexChar(char c) {
        return Character.isDigit(c) || Character.isUpperCase(c) && c <= 'F' || Character.isLowerCase(c) && c <= 'f';
    }
}
