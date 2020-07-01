package org.shuize.picturemanage.picture.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author shuize
 * @since 2020-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TPicture对象", description="")
public class TPicture implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String pictureaddress;

    private String picturedescription;

    private String picturename;

    @TableField(fill = FieldFill.INSERT)
    private String picturetime;


}
