package com.wgx.day26;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wgx
 * @since 2023/3/3 9:32
 *
 * 给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
 *
 * 由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
 *
 * 返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
 */
public class 保证文件名唯一 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFolderNames(new String[]{"pes", "fifa", "gta", "pes(2019)"})));
    }

    public static String[] getFolderNames(String[] names) {
        int n = names.length;
        var res = new String[n];
        var map = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (map.containsKey(name)) {
                int val = map.get(name);
                while (map.containsKey(name + "(" + val + ")")) {
                    ++val;
                }
                res[i] = name + "(" + val + ")";
                map.put(name + "(" + val + ")", 1);
                map.put(name, val + 1);
            } else {
                map.put(name, 1);
                res[i] = name;
            }
        }
        return res;
    }
}
