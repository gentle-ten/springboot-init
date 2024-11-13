package com.init.manager;

import com.aliyun.oss.*;
import com.aliyun.oss.model.*;
import com.init.config.OssClientConfig;
import com.init.common.exception.BusinessException;
import com.init.common.exception.ErrorCode;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * OSS 对象存储操作
 */
@Component
public class OssManager {

    @Resource
    private OssClientConfig ossClientConfig;
    @Resource
    private OSS ossClient;

    /**
     * 上传对象
     *
     * @param key           唯一键
     * @param localFilePath 本地文件路径
     * @return PutObjectResult 对象
     */
    public PutObjectResult putObject(String key, String localFilePath) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(ossClientConfig.getBucketName(), key, new File(localFilePath));
        return ossClient.putObject(putObjectRequest);
    }

    /**
     * 上传对象
     *
     * @param key  唯一键
     * @param file 文件
     * @return PutObjectResult 对象
     */
    public PutObjectResult putObject(String key, File file) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(ossClientConfig.getBucketName(), key, file);
        return ossClient.putObject(putObjectRequest);
    }

    /**
     * 文件下载
     *
     * @param response 响应头
     * @param filePath 文件完整路径
     */
    public void downLoad(HttpServletResponse response, String filePath) {
        try {
            OSSObject ossObject = ossClient.getObject(ossClientConfig.getBucketName(), filePath);
            // 设置响应头，使得浏览器能够直接下载文件
            response.setHeader("Content-Disposition", "attachment;filename*=UTF-8''" + filePath);
            response.setContentType(ossObject.getObjectMetadata().getContentType());
            // 将输入流的内容复制到输出流。实现从 OSS（对象存储服务）下载文件并将其写入到 HTTP 响应中，使得客户端浏览器能够直接下载该文件
            IOUtils.copy(ossObject.getObjectContent(), response.getOutputStream());
        } catch (IOException e) {
            // 处理IOException异常
            throw new BusinessException(ErrorCode.OSS_DOWNLOAD_ERROR);
        } finally {
            closeResources(ossClient);
        }
    }

    private void closeResources(OSS ossClient) {
        if (ossClient != null) {
            ossClient.shutdown();
        }
    }

    /**
     * 列举文件
     *
     * @return List<OSSObjectSummary>
     */
    public List<OSSObjectSummary> listFiles() {
        // 列举文件。
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(ossClientConfig.getBucketName());
        // 设置正斜线（/）为文件夹的分隔符。
        listObjectsRequest.setDelimiter("/");
        // 列举所有包含指定前缀的文件，并使用正斜线（/）作为文件夹的分隔符。
        listObjectsRequest.setPrefix("");
        // 列举文件。如果不设置keyPrefix，则列举存储空间下的所有文件。如果设置keyPrefix，则列举包含指定前缀的文件。
        ObjectListing objectListing = ossClient.listObjects(ossClientConfig.getBucketName());
        // 创建OSSClient实例。
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (OSSObjectSummary s : sums) {
            System.out.println("\t" + s.getKey());
        }
        return sums;
    }


}
