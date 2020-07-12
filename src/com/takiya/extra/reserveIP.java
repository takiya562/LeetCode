package com.takiya.extra;

public class reserveIP {
    public static String reserve(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; --i) {
            if (i == 0)
                sb.append(parts[i]);
            else
                sb.append(parts[i] + ".");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reserve("192.168.1.2"));
    }
}
