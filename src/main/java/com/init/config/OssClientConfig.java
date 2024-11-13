package com.init.config;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "oss.client")
public class OssClientConfig {

  /** 连接的 OSS 服务器所在的区域 */
  private String endpoint;

  /** 访问密钥 ID（标识阿里云账号） */
  private String keyId;

  /** 访问密钥密钥（AccessKey Secret） */
  private String keySecret;

  /** 创建的存储桶（Bucket）的名称，名称必须是唯一的 */
  private String bucketName;

  /**
   * 创建 OSSClient 实例（OSS客户端实例）
   *
   * @return OSSClient
   */
  @Bean
  public OSS ossClient() {
    // 使用配置文件来传递凭证信息。
    CredentialsProvider credentialsProvider = new DefaultCredentialProvider(keyId, keySecret);
    return new OSSClientBuilder().build(endpoint, credentialsProvider);
  }
}
