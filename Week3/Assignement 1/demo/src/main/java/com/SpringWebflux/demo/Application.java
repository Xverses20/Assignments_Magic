package com.SpringWebflux.demo;

import org.springframework.beans.BeanUtils;

public class Application {
    public static <Student> DataTransferObject entitytoData(Student student){
        DataTransferObject dataobject  = new DataTransferObject();
        BeanUtils.copyProperties(student , dataobject);
        return dataobject;
    }
    public static Student datatoToEntity(DataTransferObject dataobject) {
        Student student = new Student();
        BeanUtils.copyProperties(dataobject, student);
        return student;
    }
}
