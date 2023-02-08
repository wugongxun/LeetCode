package com.wgx.day20;

import java.util.*;

/**
 * @author wgx
 * @since 2023/2/7 9:39
 */
public class 警告一小时内使用相同员工卡大于等于三次的人 {
    public static void main(String[] args) {
        System.out.println(alertNames(new String[]{"a","a","a","a","a","b","b","b","b","b","b"},
                new String[]{"23:20","23:02","23:30","11:09","15:28","22:57","23:40","03:43","21:55","20:38","00:19"}));
    }

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
//        int n = keyName.length;
//        var map = new TreeMap<String, TreeSet<int[]>>();
//        for (int i = 0; i < n; i++) {
//            var name = keyName[i];
//            var time = keyTime[i];
//            var splitTime = time.split(":");
//            int hour = Integer.parseInt(splitTime[0]);
//            int minute = Integer.parseInt(splitTime[1]);
//            var times = map.getOrDefault(name, new TreeSet<>(Arrays::compare));
//            if (times.size() == 0) {
//                map.put(name, times);
//            }
//            times.add(new int[]{hour, minute});
//        }
//        var res = new ArrayList<String>();
//        map.forEach((key, val) -> {
//            var list = new ArrayList<>(val);
//            for (int i = 2; i < list.size(); i++) {
//                var prevTime = list.get(i - 2);
//                var curTime = list.get(i);
//                if (curTime[0] - prevTime[0] == 0 || (curTime[0] - prevTime[0] == 1 && curTime[1] <= prevTime[1])) {
//                    res.add(key);
//                    break;
//                }
//            }
//        });
//        return res;


        var map = new HashMap<String, List<Integer>>();
        var n = keyName.length;
        for (int i = 0; i < n; i++) {
            var name = keyName[i];
            var time = keyTime[i];
            map.putIfAbsent(name, new ArrayList<>());
            var splitTime = time.split(":");
            map.get(name).add(Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]));
        }
        var res = new ArrayList<String>(map.size());
        map.forEach((key, val) -> {
            Collections.sort(val);
            for (int i = 2; i < val.size(); i++) {
                var prevTime = val.get(i - 2);
                var curTime = val.get(i);
                if (curTime - prevTime <= 60) {
                    res.add(key);
                    break;
                }
            }
        });
        Collections.sort(res);
        return res;
    }
}
