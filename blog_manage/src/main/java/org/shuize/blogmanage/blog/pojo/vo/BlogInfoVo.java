package org.shuize.blogmanage.blog.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogInfoVo {
    private String title;
    private Long typeId;
}
