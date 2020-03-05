package org.zpli.java8.fileapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/5 15:11
 */
public class FileDemo {
    public static void main(String[] args) throws Exception {

        String path = FileDemo.class.getClassLoader().getResource("first.txt").getPath().replaceFirst("/", "");
        System.out.println(path);
        byte[] fileBytes = Files.readAllBytes(Paths.get(path));
        System.out.println(new String(fileBytes, "utf-8"));
    }
}
