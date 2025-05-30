package com.vegdog;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.model.*;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class OssJavaSdkQuickStart {

    public static void main(String[] args) {
        // 设置 OSS Endpoint 和 Bucket 名称（确保已存在）
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        String bucketName = "tlias-vegdog";

        // 替换为您的 Bucket 区域
        String region = "cn-beijing";

        // 从环境变量中获取访问凭证。运行本代码示例之前，请先配置环境变量
        EnvironmentVariableCredentialsProvider credentialsProvider = null;
        try {
            credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        } catch (com.aliyuncs.exceptions.ClientException e) {
            System.err.println("无法获取凭证，请检查环境变量是否设置正确");
            e.printStackTrace();
            return;
        }

        // 创建 OSSClient 实例
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4); // 使用 V4 签名算法

        OSS ossClient = OSSClientBuilder.create()
                .endpoint(endpoint)
                .credentialsProvider(credentialsProvider)
                .region(region)
                .build();

        try {
            // 1. 上传图片文件
            String objectName = "uploads/test-image.png"; // 上传到 OSS 的路径
            String filePath = "D:\\files\\Pictures\\wallhaven-ex55o8_2560x1440.png"; // 本地图片路径，请替换为你自己的图片路径

            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("本地文件不存在: " + filePath);
                return;
            }

            // 自动识别 MIME 类型
            Path path = Paths.get(filePath);
            String mimeType = Files.probeContentType(path);

            ObjectMetadata metadata = new ObjectMetadata();
            if (mimeType != null) {
                metadata.setContentType(mimeType);
            }

            ossClient.putObject(bucketName, objectName, new FileInputStream(file), metadata);
            System.out.println("1. 图片文件 " + objectName + " 上传成功。");

            /*// 2. 下载文件（可选验证）
            String downloadFilePath = "D:/images/downloaded-test.jpg";
            OSSObject ossObject = ossClient.getObject(bucketName, objectName);
            try (InputStream inputStream = ossObject.getObjectContent();
                 OutputStream outputStream = new FileOutputStream(downloadFilePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                System.out.println("2. 文件已下载至: " + downloadFilePath);
            }*/

            // 3. 列出 Bucket 中的文件
            System.out.println("3. 列出 Bucket 中的文件：");
            ObjectListing objectListing = ossClient.listObjects(bucketName);
            List<OSSObjectSummary> summaries = objectListing.getObjectSummaries();
            for (OSSObjectSummary summary : summaries) {
                System.out.println(" - " + summary.getKey() + " (大小 = " + summary.getSize() + ")");
            }

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (Exception ce) {
            System.out.println("发生异常：");
            ce.printStackTrace();
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
