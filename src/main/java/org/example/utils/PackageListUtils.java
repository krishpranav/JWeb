package org.example.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;


public class PackageListUtils {

    private static String root = PackageListUtils.class.getClassLoader().getResource("").getPath(); 
    private static String separator = File.separator; 
    private static List<Class> classes;

    public static List<Class> getAllClass() {
        root = new File(root).getPath(); 
        classes = new ArrayList<>();
        listFilesForFolder(new File(root));
        return classes;
    }

    private static void listFilesForFolder(File folder) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                listFilesForFolder(file);
            } else {
                String path = file.getPath();
                if (path.endsWith(".class")) {
                    String classPath = path.replaceAll(Matcher.quoteReplacement(root), "") 
                            .replaceAll(Matcher.quoteReplacement(separator), ".") 
                            .replaceAll(".class", ""); 

                    if (classPath.startsWith(Matcher.quoteReplacement("."))) 
                        classPath = classPath.replaceFirst(Matcher.quoteReplacement("."), "");
                    try {
                        classes.add(Class.forName(classPath));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}