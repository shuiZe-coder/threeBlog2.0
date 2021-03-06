package org.shuize.blogmanage.blog.pojo.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
public class BlogDescription {
    private Long id;
    private String title;
    private String type;
    private Boolean shareStatement;
    private String description;
    private String firstPicture;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date updateTime;
    private Boolean published;
}
