package http.server;

import java.util.ArrayList;
import java.util.List;

/**
 * <servelt-mapping>
 *     <servlet-name>login</servlet-name>
 *     <url-pattern>/login</url-pattern>
 * </servelt-mapping>
 * <servelt-mapping>
 *     <servlet-name>login</servlet-name>
 *     <url-pattern>/log</url-pattern>
 * </servelt-mapping>
 */
public class Mapping {
    private String name;
    private List<String> urlPattern;

    public Mapping() {
        this.urlPattern = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getUrlPattern() {
        return urlPattern;
    }

    public void setName(String name) {
        this.name = name;
    }

}
