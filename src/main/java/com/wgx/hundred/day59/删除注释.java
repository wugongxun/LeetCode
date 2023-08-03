package com.wgx.hundred.day59;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/8/3 12:33
 */
public class 删除注释 {
    public static void main(String[] args) {
        System.out.println(removeComments(new String[]{
                "/*Test program */",
                "int main()", "{ ",
                "  // variable declaration ",
                "int a, b, c;", "/* This is a test",
                "   multiline  ",
                "   comment for ",
                "   testing */",
                "a = b + c;", "}"
        }));
    }

    public static List<String> removeComments(String[] source) {
        var res = new ArrayList<String>();
        var isBlockComment = false;
        var newLine = new StringBuilder();
        for (var line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (isBlockComment) {
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        isBlockComment = false;
                        i++;
                    }
                } else {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        isBlockComment = true;
                        i++;
                    } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break;
                    } else {
                        newLine.append(line.charAt(i));
                    }
                }
            }
            if (!isBlockComment && !newLine.isEmpty()) {
                res.add(newLine.toString());
                newLine.setLength(0);
            }
        }
        return res;
    }
}
