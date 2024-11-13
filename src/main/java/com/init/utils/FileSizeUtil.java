package com.init.utils;

import org.springframework.web.multipart.MultipartFile;

public class FileSizeUtil {

    /**
     * 将文件大小从字节转换为人类可读的格式（KB、MB、GB）
     *
     * @param file MultipartFile对象
     * @return 转换后的文件大小字符串
     */
    public static String getFileSizeReadable(MultipartFile file) {
        long fileSize = file.getSize();
        if (fileSize < 1024) {
            return fileSize + " B";
        } else if (fileSize < 1024 * 1024) {
            return String.format("%.1f KB", fileSize / 1024.0);
        } else if (fileSize < 1024 * 1024 * 1024) {
            return String.format("%.1f MB", fileSize / (1024.0 * 1024));
        } else {
            return String.format("%.1f GB", fileSize / (1024.0 * 1024 * 1024));
        }
    }

    /**
     * 计算文件大小
     *
     * @param fileSize 文件大小，单位为字节
     * @return 转换后的文件大小字符串，单位为B、KB、MB、GB
     */
    public static String getFileSizeReadable(long fileSize) {
        if (fileSize < 1024) {
            return fileSize + " B";
        } else if (fileSize < 1024 * 1024) {
            return String.format("%.1f KB", fileSize / 1024.0);
        } else if (fileSize < 1024 * 1024 * 1024) {
            return String.format("%.1f MB", fileSize / (1024.0 * 1024));
        } else {
            return String.format("%.1f GB", fileSize / (1024.0 * 1024 * 1024));
        }
    }
}
