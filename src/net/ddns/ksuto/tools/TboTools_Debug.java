package net.ddns.ksuto.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thomas.bouchardon on 16/03/2017!
 */
public class TboTools_Debug {
    
    public static void sout(String print) {
        
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        
        String className = stackTraceElements[2].getClassName();
        
        Pattern pattern = Pattern.compile("net\\.ddns\\.ksuto\\..*?\\.");
        Matcher matcher = pattern.matcher(className);
        
        String app = "";
        if (matcher.find()) {
            app = matcher.group(0).substring(15, matcher.group(0).length() - 1);
            className = className.replace(matcher.group(0), "");
            app = String.valueOf(app.charAt(0)).toUpperCase() + app.substring(1);
        }
        
        pattern = Pattern.compile(".*?\\.");
        matcher = pattern.matcher(className);
        String classe = "";
        if (matcher.find()) {
            classe = className.replace(matcher.group(0), "");
        }
        
        String method = stackTraceElements[2].getMethodName();
        
        int line = stackTraceElements[2].getLineNumber();
    
        System.out.println(TboTools_Time.getTime() + " : " + app + " -> " + classe + " -> " + method + "() : (L" + line + ") " + print);
    }
}
