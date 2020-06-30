package org.shuize.blogmanage.blog.pojo.vo;


import lombok.Data;
import lombok.ToString;

import java.util.Date;


@Data
@ToString
public class BlogDetail {

    private Boolean appreciation;

    private Boolean commentabled;

    private String content;

    private Date createTime;

    private String description;

    private String firstPicture;

    private String flag;

    private Boolean published;

    private Boolean recommend;

    private Boolean shareStatement;

    private String title;

    private Date updateTime;

    private Integer views;

    private Long typeId;

    private Long userId;

    private Integer commentCount;

    private String typeName;
}
