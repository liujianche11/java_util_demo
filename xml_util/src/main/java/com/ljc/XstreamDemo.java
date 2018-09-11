package com.ljc;

import com.ljc.entity.Address;
import com.ljc.entity.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.xml.sax.InputSource;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class XstreamDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setId(100L);
        user.setAge(10);
        user.setName("test01");
        List<Address> addresses = new ArrayList<Address>();
        user.setAddresses(addresses);
        for (int i = 0; i < 5; i++) {
            Address addr = new Address();
            addr.setProvince("省" + i);
            addr.setCity("市" + i);
            addr.setCounty("区" + i);
            addr.setStreet("街道" + i);
            addr.setDetail("详细地址" + i);
            addresses.add(addr);
        }

        //对象转xml
        XStream xStream = new XStream(new StaxDriver());
        //全路径类名可以使用别名来代替
        xStream.alias("user",User.class);
        xStream.alias("address",Address.class);
        //设置某个字段一属性的形式
        xStream.useAttributeFor(User.class,"age");
        //使用别名代替字段名
        xStream.aliasField("省",Address.class,"province");
        //list不想要显示根
        xStream.addImplicitCollection(User.class,"addresses");

        String xml = xStream.toXML(user);
        System.out.println(formatXml(xml));



    }



    public static String formatXml(String xml){
        try{
            Transformer serializer= SAXTransformerFactory.newInstance().newTransformer();
            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
            serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            Source xmlSource=new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes())));
            StreamResult res =  new StreamResult(new ByteArrayOutputStream());
            serializer.transform(xmlSource, res);
            return new String(((ByteArrayOutputStream)res.getOutputStream()).toByteArray());
        }catch(Exception e){
            return xml;
        }
    }
}

