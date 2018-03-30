package com.ll.wagesmanager;


import me.cf81.commons.web.model.ResultMessage;

public enum Exceptions implements ResultMessage {
    ERROR("2000", "错误"),
    EXSIT_ERROR("2001", "该项已存在！"),
    GET_DATA_ERROR("2002", "获取数据失败！"),
    EXSIT_CHILDREN_ERROR("2003","存在子关联未删除！"),
    IMPORT_ERROR("2004", "导入失败！"),
    SPAREPART_ERROR("2005","导出失败"),
    INSERT_ERROR("2006","新增失败")
    ;

    Exceptions(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
