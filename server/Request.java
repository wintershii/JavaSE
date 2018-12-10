package http.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Request {
    //请求方式
    private String method;
    //请求资源
    private String url;
    //请求参数
    private Map<String,List<String>> parameterMapValues;
    //内部
    private static final String CRLF = "\r\n";
    private InputStream is;
    private String requestInfo;

    public Request(){
        method = "";
        url = "";
        parameterMapValues = new HashMap<>();
        requestInfo = "";
    }

    public Request(InputStream is) throws IOException {
        this();
        this.is = is;
        byte[] data = new byte[20480];
        int len = is.read(data);
        requestInfo = new String(data,0,len);
        //分析头信息
        parseRequestInfo();
    }

    private void parseRequestInfo() {
        if (requestInfo == null || requestInfo.trim().equals("")) {
            return;
        }
        /**
         * 从信息首行分解出请求方式，请求路径，请求参数
         * 如果是get方式，第一行全部能得到
         * 如果是post方式，请求参数可能在最后正文中
         */
        String paramString = "";//接受请求参数
        //获取请求方式
        String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
        int idx = firstLine.indexOf("/");
        String urlStr = firstLine.substring(idx, firstLine.indexOf("HTTP/")).trim();
        this.method = firstLine.substring(0, idx).trim();
        if (this.method.equalsIgnoreCase("post")) {
            this.url = urlStr;
            paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
        } else if (this.method.equalsIgnoreCase("get")) {
            if (urlStr.contains("?")) {      //是否存在参数
                String[] urlArray = urlStr.split("\\?");
                this.url = urlArray[0];
                paramString = urlArray[1];
            } else {
                this.url = urlStr;
            }
        }
        // 将请求参数封装到Map中
        //不存在请求参数
        if (paramString.equals("")) {
            return;
        }
        parseParams(paramString);
    }

    private void parseParams(String paramString){
        //分割  将字符串转成字符
        StringTokenizer token = new StringTokenizer(paramString,"&");
        while (token.hasMoreTokens()){
            String keyValue = token.nextToken();
            String[] keyValues = keyValue.split("=");
            if (keyValues.length == 1){
                keyValues = Arrays.copyOf(keyValues,2);
                keyValues[1] = null;
            }

            String key = keyValues[0].trim();
            String value = null == keyValues[1] ? null : decode(keyValues[1].trim(),"gbk");
            //转换成map
            if (! parameterMapValues.containsKey(keyValues[0].trim())){
                parameterMapValues.put(key,new ArrayList<>());
            }
            List<String> values = parameterMapValues.get(key);
            values.add(value);

        }
    }

    /**
     *  根据页面的name 获取对应的多个值
     */
    public String[] getParameterValues(String name){
        List<String> values = null;
        if ( (values = (parameterMapValues.get(name))) == null){
            return null;
        }else {
            return values.toArray(new String[0]);
        }
    }

    /**
     *  根据页面的name  获取对应的多个值
     */
    public String getParameter(String name){
        String[] values = getParameterValues(name);
        if (values == null){
            return null;
        }
        return values[0];
    }

    /**
     * 解决中文的解码问题
     * @param values
     * @param code
     * @return
     * @throws UnsupportedEncodingException
     */
    private String decode(String values,String code) {
        try {
            return java.net.URLDecoder.decode(values,code);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUrl(){
        return this.url;
    }
}
