package com.lgp.drools.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtils {
    public static String regex1 = "[&|]+";
    public static String REGEX = "[>=<|]{1,}";

    public static void main(String[] args) {
        String baseStr = "a>10 & 10 -2 || 1 < 4";
        String s = AddBoc(baseStr, regex1);
        System.out.println("s:" + s);
    }

    private static String AddBoc(String baseStr, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(baseStr);
        StringBuffer buffer = new StringBuffer();
        String dateStr = null;
        int lastIndex = 0;
        while (matcher.find()) {
            StringBuffer tempBuffer = new StringBuffer();
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("start=" + start + ", end= " + end);
            if (lastIndex == 0) {
                tempBuffer.append("(").append(baseStr.substring(0, start)).append(")");
            } else {
                tempBuffer.append("(").append(baseStr.substring(lastIndex, start)).append(")");
            }
            String boc = AddBoc(tempBuffer.toString(), REGEX);
            buffer.append(boc);
            buffer.append(baseStr.substring(start, end));
            lastIndex = end;
        }
        if (lastIndex > 0) {
            String substring = baseStr.substring(lastIndex, baseStr.length());
            String boc = AddBoc(substring.toString(), REGEX);
            buffer.append("(").append(boc).append(")");
            return buffer.toString();
        } else {
            return baseStr;
        }
    }


}
