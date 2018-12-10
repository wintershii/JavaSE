package http.server;

/**
 * <servelt>
 *     <servlet-name>login</servlet-name>
 *     <servlet-class>  http.server.LoginServlet</servlet-class>
 * </servelt>
 */
public class Entity {
    private String name;
    private String clz;

    public String getName() {
        return name;
    }

    public String getClz() {
        return clz;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }
}
