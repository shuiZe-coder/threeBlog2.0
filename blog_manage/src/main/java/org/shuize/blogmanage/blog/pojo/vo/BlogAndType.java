package org.shuize.blogmanage.blog.pojo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value="包含Type的TBlog对象", description="")
public class BlogAndType implements Serializable {


    private String description;

    private String firstPicture;

    private Boolean recommend;

    private String title;

    private Date updateTime;

    private Long userId;

    private Integer views;

    private Integer commentCount;

    private String typeName;

}
