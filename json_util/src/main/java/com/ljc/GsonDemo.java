package com.ljc;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.ljc.entity.Address;
import com.ljc.entity.User;

import java.util.ArrayList;
import java.util.List;

public class GsonDemo {

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

        //gson两个基本的方法toJson()和fromJson()
        Gson gson = new Gson();
        String json = gson.toJson(user);
        System.out.println(json);
        System.out.println("--------------------------");
        User user2 = gson.fromJson(json, User.class);
        System.out.println(user2);

        //复杂对象转换
        json = gson.toJson(addresses);
        System.out.println(json);
        List<Address> addrs = gson.fromJson(json, new TypeToken<List>() {
        }.getType());
        System.out.println("addrs=" + addrs);

        //判断字符串是否是json
        try {
            new JsonParser().parse(json).getAsJsonObject();
            System.out.println(true);
        } catch (Exception e) {
            System.out.println(false);
        }
    }
}