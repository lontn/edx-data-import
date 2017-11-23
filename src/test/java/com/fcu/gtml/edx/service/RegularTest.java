package com.fcu.gtml.edx.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest {
    public static void main(String[] args) {
        // case 1 : 取得特定group的內容
        String data = "P3DT3H20M";
        String pattern = "^P(?:(\\d{1,2})D)?T(?:(\\d{1,2})H)?(?:(\\d{1,2})M)?(?:(\\d{1,2})S)?";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(data);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
            System.out.println("Found value: " + m.group(4));
        } else {
            System.out.println("NO MATCH");
        }

        System.out.println("-------------------------------------");

        // case 2 : 針對特定group做變化
        String data2 = "aaa,bbb";
        String pattern2 = "([,])(?=[a-zA-Z])";

        System.out.println("result_before:" + data2);
        data2 = data2.replaceAll(pattern2, "$1 ");
        System.out.println("result_after:" + data2);
    }

}
