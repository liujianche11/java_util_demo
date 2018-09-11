package com.ljc;

import com.ljc.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionUtilsDemo {

    public static void main(String[] args) {
        //addIgnoreNull();
        //collate();
        collect();

    }

    //往集合增加元素时忽略空对象
    public static void addIgnoreNull(){
        List<User> list = new ArrayList<User>();
        User user = new User();
        CollectionUtils.addIgnoreNull(list,user);
        User user2 = null;
        //空的会被忽略
        CollectionUtils.addIgnoreNull(list,user2);
        System.out.println(list);
    }

    //合并两个有序队列
    public static void collate(){
        List<String> sortList1 = Arrays.asList("A","C","G");
        List<String> sortList2 = Arrays.asList("B","D","X");

        List<String> mergeList = CollectionUtils.collate(sortList1,sortList2);
        System.out.println(mergeList);
    }

    //将一种对象的集合转换成另外一种对象的集合
    public static void collect(){
        List<String> stringList = Arrays.asList("1","2","3");
        System.out.println(stringList);
        List<Integer> integerList = (List<Integer>) CollectionUtils.collect(stringList,
                new Transformer<String, Integer>() {

                    @Override
                    public Integer transform(String input) {
                        return Integer.parseInt(input);
                    }
                });

        System.out.println(integerList);
    }
}
