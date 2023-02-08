package com.wgx.day20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/2/8 10:13
 */
public class 删除子文件夹 {
    public static void main(String[] args) {
        System.out.println(removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}));
    }

    public static List<String> removeSubfolders(String[] folder) {
        //创建字典树
        var root = new TrieNode("", false);
        for (int i = 0; i < folder.length; i++) {
            var folders = folder[i].split("/");
            var temp = root;
            for (int j = 1; j < folders.length; j++) {
                var curFolder = folders[j];
                var list = temp.children;
                int index = -1;
                for (int k = 0; k < list.size(); k++) {
                    if (list.get(k).name.equals(curFolder)) {
                        index = k;
                        break;
                    }
                }
                if (index >= 0) {
                    var node = list.get(index);
                    if (node.exist) {
                        break;
                    } else {
                        node.exist = (j == folders.length - 1);
                        temp = node;
                    }
                } else {
                    var newNode = new TrieNode(curFolder, (j == folders.length - 1));
                    list.add(newNode);
                    temp = newNode;
                }
            }
        }

        //遍历字典树
        var res = new ArrayList<String>();
        each(res, root, "");
        return res;
    }

    public static void each(List<String> res, TrieNode node, String cur) {
        cur = cur + "/" + node.name;
        if (node.exist) {
            res.add(cur.substring(1));
            return;
        }
        var children = node.children;
        for (int i = 0; i < children.size(); i++) {
            each(res, children.get(i), cur);
        }
    }
}

class TrieNode {
    String name;
    boolean exist;
    List<TrieNode> children;

    public TrieNode(String name, boolean exist) {
        this.name = name;
        this.exist = exist;
        children = new ArrayList<>();
    }
}
