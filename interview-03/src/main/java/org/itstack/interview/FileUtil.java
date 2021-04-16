package org.itstack.interview;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class FileUtil {

    /**
     * 读取本地文件，单词表
     * @param url 单词表.txt文件
     * @return 单词集合(去重)
     */
    public static Set<String> readWordList(String url) {
        Set<String> set = new HashSet<>();

        try(InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(url),StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(inputStreamReader);
        ) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("\t");

                set.add(arr[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;


    }




}
