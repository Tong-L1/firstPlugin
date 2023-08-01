package com.smxd.firstPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AutoInstall {

    /**
     * 主方法
     */
    public static void main(String[] args) throws IOException {
        File source = new File("D:\\mcPlugins\\firstPlugin\\target\\firstPlugin-1.0-SNAPSHOT.jar");
        File target = new File("E:\\games\\MC\\paper-1.20.1\\plugins\\firstPlugin-1.0-SNAPSHOT.jar");
        System.out.println("插件更新" + copyFileUsingJava7Files(source, target));
        //打印一下时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(dateFormat.format(date));
    }

    /**
     * 自动安装插件
     */
    private static String copyFileUsingJava7Files(File source, File target) throws IOException {
        boolean fileDelete = target.delete();
        if (fileDelete) { //已删除原插件
            //添加新插件
            Files.copy(source.toPath(), target.toPath());
        }
        return fileDelete ? "成功" : "失败";
    }
}
