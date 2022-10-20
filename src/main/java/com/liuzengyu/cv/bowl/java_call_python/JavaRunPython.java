package com.liuzengyu.cv.bowl.java_call_python;

import lombok.extern.slf4j.Slf4j;
import org.python.util.PythonInterpreter;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

@Slf4j
public class JavaRunPython {
    public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("a='hello world'; ");
        interpreter.exec("print a;");
//        interpreter.exec("a=[5,2,3,9,4,0]; ");
//        interpreter.exec("print(sorted(a));");  //此处python语句是3.x版本的语法
//        interpreter.exec("print sorted(a);");   //此处是python语句是2.x版本的语法

        Properties props = new Properties();
        props.put("python.home", "/opt/homebrew/anaconda3/envs/python361");
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "true");
        Set<String> set =props.stringPropertyNames();
        Enumeration enumeration=props.propertyNames();
        while (enumeration.hasMoreElements()){
            String curKey = enumeration.nextElement().toString();
            log.info(curKey);

        }
//        log.info(props.stringPropertyNames().toArray().toString());
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        PythonInterpreter pyInterpreter = new PythonInterpreter();
        pyInterpreter.exec("import sys");
        pyInterpreter.exec("a=[5,2,3,9,4,0]; ");
        pyInterpreter.exec("print(sorted(a));");
        pyInterpreter.exec("print sorted(a);");
    }
}
