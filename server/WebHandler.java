package http.server;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class WebHandler extends DefaultHandler {
    private List<Entity> entityList;
    private List<Mapping> mappingList;
    private Entity entity;
    private Mapping mapping;
    private String beginTag;

    private boolean isMap;


    @Override
    public void startDocument(){
        //文档解析开始
        entityList = new ArrayList<>();
        mappingList = new ArrayList<>();
    }

    @Override
    public void endDocument() {
        //文档解析结束
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)  {
        //开始元素
        if (qName != null){
            beginTag = qName;
            if (qName.equals("servlet")){
                isMap = false;
                entity = new Entity();

            }else if (qName.equals("servlet-mapping")){
                isMap = true;
                mapping = new Mapping();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        //结束元素
        if (qName != null){

            if (qName.equals("servlet")){
                entityList.add(entity);
            }else if (qName.equals("servlet-mapping")){
                mappingList.add(mapping);
            }

        }
        beginTag = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        //处理内容
        if (beginTag != null){
            String str = new String(ch,start,length);
            if (isMap){
                if (beginTag.equals("servlet-name")){
                        mapping.setName(str);
                }else if (beginTag.equals("url-pattern")){
                        mapping.getUrlPattern().add(str);
                }
            }else {
                if (beginTag.equals("servlet-name")){
                    entity.setName(str);
                }else if (beginTag.equals("servlet-class")){
                        entity.setClz(str);
                }
            }
        }

    }


    public List<Entity> getEntityList() {
        return entityList;
    }

    public List<Mapping> getMappingList() {
        return mappingList;
    }
}
