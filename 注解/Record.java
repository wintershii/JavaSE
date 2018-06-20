package com.annotation;

public class Record {

    //@Field_Method_Parameter_Annotation(decribe = "编号",type = int.class);
    int id;
    //@Field_Method_Parameter_Annotation(decribe = "姓名",type = String.class);
    String name;
    @Constructor_Annotation()
    public Record(){

    }
    //@Constructor_Annotation("立即初始化构造方法");
    public Record(
            @Field_Method_Parameter_Annotation(decribe = "编号",type = int.class)int id,
            @Field_Method_Parameter_Annotation(decribe = "姓名",type = String.class)String name){
        this.id = id;
        this.name = name;
    }

    @Field_Method_Parameter_Annotation(decribe = "获得编号",type = int.class)
    public int getId(){
        return id;
    }
    @Field_Method_Parameter_Annotation(decribe = "设置编号")
    public void setId(
            @Field_Method_Parameter_Annotation(decribe = "编号",type = int.class)int id){
            this.id = id;
    }

    @Field_Method_Parameter_Annotation(decribe = "获得姓名",type = String.class)
    public String getName(){
        return name;
    }
    @Field_Method_Parameter_Annotation(decribe = "设置姓名")
    public void setName(
            @Field_Method_Parameter_Annotation(decribe = "姓名",type = String.class)String name){
        this.name = name;
    }

}
