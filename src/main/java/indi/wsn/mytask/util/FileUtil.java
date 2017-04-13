package indi.wsn.mytask.util;

import java.io.File;
import java.io.IOException;

/**
 * FileName: FileUtil.java
 * 文件创建工具
 *
 * @author SharingWoo
 * @version 1.00
 * @Date 2017/4/13
 */
public class FileUtil {
    /**
     * 创建文件
     *
     * @param fileName 需要创建的文件名
     * @return 成功与否（false:失败;true:成功）
     */
    public static boolean createFile(String fileName) throws IOException {
        File file = new File(fileName);
        //the file already exists!
        if (file.exists()) {
            return false;
        }
        //the file catalog can not be a file
        if (fileName.endsWith(File.separator)) {
            return false;
        }
        if(!file.getParentFile().exists()) {
            makeDir(file.getParent());
        }
        return file.createNewFile();
    }

    /**
     * create the director of the file
     *
     * @param fileDir the file director
     * @return is successful or not
     */
    public static boolean makeDir(String fileDir) throws IOException {
        File file = new File(fileDir);
        if (file.exists()) {
            return false;
        }
        //create the file catalog
        return file.mkdirs();
    }

    /**
     * template file create
     *
     * @param prefix  the prefix of the template file
     * @param suffix  the suffix of the template file
     * @param dirName the catalog of the template file
     * @return is successful or not
     */
    public static boolean temFileCreate(String prefix, String suffix, String dirName) throws IOException {
        File temFile = new File(dirName);
        //the template file already exists
        if(temFile.exists()) {
            return false;
        }
        temFile.mkdirs();

        File.createTempFile(prefix,suffix,temFile);
        return true;
    }
}
