package org.itstack.interview.test;

import com.alibaba.fastjson.JSON;
import org.itstack.interview.Disturb;
import org.itstack.interview.FileUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class ApiTest {

    private Set<String> words;

    @Before
    public void before() {
        // 读取文件，103976个英语单词库.txt
        words = FileUtil.readWordList("E:\\java-base\\interview\\docs\\103976个英语单词库.txt");
    }

    @Test
    public void test_disturb() {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (String word : words) {
            // 使用扰动函数
            int idx = Disturb.disturbHashIdx(word, 128);
            // 不使用扰动函数
            //int idx = Disturb.hashIdx(word, 128);
            if (map.containsKey(idx)) {
                Integer integer = map.get(idx);
                map.put(idx, ++integer);
            } else {
                map.put(idx, 1);
            }
        }
        System.out.println(map.values());
    }


    @Test
    public void test_threshold() {
        System.out.println(tableSizeFor(17));
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= (1 << 30)) ? (1 << 30) : n + 1;
    }

    @Test
    public void test_hashMapSize() {
        Map<String, String> map = new HashMap<>(17);
        System.out.println(map.keySet().size());
    }

    @Test
    public void test_hashMap() {
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("jmdw");
        list.add("e4we");
        list.add("io98");
        list.add("nmhg");
        list.add("vfg6");
        list.add("gfrt");
        list.add("alpo");
        list.add("vfbh");
        list.add("bnhj");
        list.add("zuio");
        list.add("iu8e");
        list.add("yhjk");
        list.add("plop");
        list.add("dd0p");
        // 原哈希值与扩容新增 出来的长度 16，
        // 进行&运算，如果值等于 0，则下标位置不变。如果不为 0，那么新的位置则是原来位置上加 16。
        // hash & oldCap != 0 被迁移到 oldIndex + oldCap位置
        for (String key : list) {
            int hash = key.hashCode() ^ (key.hashCode() >>> 16);
            System.out.println("字符串：" + key + " \tIdx(16)：" + ((16 - 1) & hash) + " hash值" + hash + " \thash Bit值："
                    + Integer.toBinaryString(hash) + " - " + Integer.toBinaryString(hash & 16)
                    + " \t\tIdx(32)：" + ((32 - 1) & hash));
            System.out.println(Integer.toBinaryString(key.hashCode()) +" "+ Integer.toBinaryString(hash) + " " + Integer.toBinaryString((32 - 1) & hash));
        }
    }


    @Test
    public void t() {
        System.out.println(Integer.toBinaryString("小傅哥".hashCode()));
        System.out.println(Integer.toBinaryString("小傅哥".hashCode() ^ ("小傅哥".hashCode() >>> 16)));
    }

    @Test
    public void test_128hash() {

        // 初始化一组字符串
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("小傅哥");
        list.add("e4we");
        list.add("alpo");
        list.add("yhjk");
        list.add("plop");

        // 定义要存放的数组
        String[] tab = new String[8];
        for(String key : list) {
            int idx = key.hashCode() & (tab.length - 1);
            System.out.println(String.format("key值 = %s idx = %d",key,idx));
            if (tab[idx] == null) {
                tab[idx] = key;
                continue;
            }
            tab[idx] = tab[idx] + "->" + key;

        }

        System.out.println(JSON.toJSONString(tab));



    }

}

//011000
//011111
//
//011000