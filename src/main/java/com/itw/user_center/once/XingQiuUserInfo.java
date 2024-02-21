package com.itw.user_center.once;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class XingQiuUserInfo {

    @ExcelProperty("成员编号")
    private String code;
    @ExcelProperty("成员昵称")
    private String username;
}