package com.yn.easyexcell.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ColumnWidth(30)//注释在具体属性上,设置单独列。注释在类上,统一设置列宽
@HeadRowHeight(30)//设置表头行高
@TableName(value = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "主键ID", index = 0)
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ExcelProperty(value = "姓名", index = 1)
    @ApiModelProperty(value = "姓名")
    private String name;

    @ExcelProperty(value = "年龄", index = 2)
    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ExcelProperty(value = "地址", index = 3)
    @ApiModelProperty(value = "地址")
    private String addr;

    @ExcelProperty(value = "创建时间", index = 4)
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

}
