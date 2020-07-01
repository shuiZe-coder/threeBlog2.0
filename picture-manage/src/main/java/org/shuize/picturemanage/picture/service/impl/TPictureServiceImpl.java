package org.shuize.picturemanage.picture.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.shuize.picturemanage.picture.pojo.TPicture;
import org.shuize.picturemanage.picture.mapper.TPictureMapper;
import org.shuize.picturemanage.picture.service.TPictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shuize
 * @since 2020-06-28
 */
@Service
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "aliyun.oss")
@Data
public class TPictureServiceImpl extends ServiceImpl<TPictureMapper, TPicture> implements TPictureService {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

    @Override
    public List<String> uploadFile(MultipartFile[] files) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        List<String> result = new ArrayList<>();

// <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        for (MultipartFile file : files) {
            String filename = file.getOriginalFilename();
            String objectName = "pictures/" + UUID.randomUUID().toString().replace("-", "") + filename;
// 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（objectName）。
            try {
                ossClient.putObject("three-blog", objectName, file.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            result.add("https://three-blog.oss-cn-beijing.aliyuncs.com/" + objectName);
            TPicture picture = new TPicture();
            picture.setPicturename(filename);
            picture.setPictureaddress("https://three-blog.oss-cn-beijing.aliyuncs.com/" + objectName);
            this.save(picture);
        }
// 关闭OSSClient。
        ossClient.shutdown();
        return result;
    }
}
