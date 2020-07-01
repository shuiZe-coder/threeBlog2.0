package org.shuize.picturemanage.picture.service;

import org.shuize.picturemanage.picture.pojo.TPicture;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shuize
 * @since 2020-06-28
 */
public interface TPictureService extends IService<TPicture> {

    List<String> uploadFile(MultipartFile[] files);
}
