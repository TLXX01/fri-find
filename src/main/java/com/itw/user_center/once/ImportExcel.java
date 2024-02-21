package com.itw.user_center.once;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Slf4j
public class ImportExcel {

    /**
     * 读取数据
     */
    public static void main(String[] args) {

        // 写法1：JDK8+
        // since: 3.0.0-beta1
        String fileName = "D:\\Idea_demo\\user_center\\src\\main\\resources\\xingqiu.xlsx";
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
        //readByListener(fileName);
        synchronousRead(fileName);
    }

    //方式一：监听器
    public static void readByListener(String fileName){
        EasyExcel.read(fileName, XingQiuUserInfo.class, new TableListener()).sheet().doRead();
    }

    //方式二：同步读
    public static void synchronousRead(String fileName) {

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<XingQiuUserInfo> list = EasyExcel.read(fileName).head(XingQiuUserInfo.class).sheet().doReadSync();
        System.out.println("总数 = "+ list.size());

        Map<String,List<XingQiuUserInfo>> listMap = list.stream()
                .filter(userInfo -> StringUtils.isNotEmpty(userInfo.getUsername()))
                .collect(Collectors.groupingBy(XingQiuUserInfo::getUsername));
        System.out.println("不重复数 = "+ listMap.keySet().size());


        // 这里 也可以不指定class，返回一个list，然后读取第一个sheet 同步读取会自动finish
        //List<Map<Integer, String>> listMap = EasyExcel.read(fileName).sheet().doReadSync();

    }


}
