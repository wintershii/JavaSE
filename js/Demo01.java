package js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.net.URL;

/**
 * 测试脚本引擎javascript代码
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

        //定义变量,存储到引擎的上下文中
        engine.put("msg","i am good");
        String str = "var user = {name:'shi',age:18,schools:['西安邮电','阿里巴巴']};";
        str += "print(user.name);";

        //执行脚本
        engine.eval(str);

        engine.eval("msg = '12345';");
        System.out.println(engine.get("msg"));

        //定义函数
        engine.eval("function add(a,b){var sum = a + b; return sum;}");
        //执行js函数
        Invocable jsInvoke = (Invocable) engine;
        Object result = jsInvoke.invokeFunction("add",new Object[]{13,20});
        System.out.println(result);

        //导入其他java包，使用其他包中的java类
//        String jsCode = "importPackage(java.util); var list = Arrays.asList([\"阿里巴巴\",\"西安邮电\"]);";
//        engine.eval(jsCode);
//
//        List<String> list = (List<String>) engine.get("list");
//        for (String temp:list){
//            System.out.println(temp);
//        }

        //执行一个js文件(将a.js放到项目的src下)
        URL url = Demo01.class.getClassLoader().getResource("a.js");
        engine.eval(new FileReader(url.getPath()));

    }
}
