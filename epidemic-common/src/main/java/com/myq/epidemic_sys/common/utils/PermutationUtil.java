package com.myq.epidemic_sys.common.utils;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @描述:获取数据的一组数据的排列组合
 * @创建日期: 2022年01月13日 22:12
 */

public class PermutationUtil {
    /**
     * 按顺序获取所有排列组合
     * @param content
     * @return  返回数组字符串
     */
    public static List<List<String>> selectAllPermutation(List<String> content){
        String[] contentArr = content.toArray(new String[0]);
        List<List<String>> result = new ArrayList<>();
        for (int i=1;i<=content.size();i++){
            result.addAll(select(contentArr,i));
        }
        return result;
    }
    /**
     * 从一个数组中取指定位数的排列组合
     * @param contents 数组
     * @param k 多少位
     */
    public static List<List<String>> select(String[]contents, int k) {
        String[] cache = new String[k];
        List<List<String>> rs = new ArrayList<>();
        subselect(rs,contents,0, 1, cache, k);
       return rs;
    }
    private static void subselect(List<List<String>> rs,String[]contents,int head, int index, String[] item, int k) {
        for (int i = head; i < contents.length + index - k; i++) {
            if (index < k) {
                item[index - 1] = contents[i];
                // System.out.println("i="+(i)+";index="+(index));
                subselect(rs,contents,i + 1, index + 1, item, k);
            } else if (index == k) {
                item[index - 1] = contents[i];
                rs.add(Arrays.asList(item.clone()));
                String[] nitem =  new String[k];//数组满了后重新开数组
                subselect(rs,contents,i + 1, index + 1, nitem, k);
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        String[] content = {"a","b","c","d"};
        List<List<String>> strings =selectAllPermutation(Arrays.asList(content));
        System.out.println(JSON.toJSONString(strings));
    }
}
