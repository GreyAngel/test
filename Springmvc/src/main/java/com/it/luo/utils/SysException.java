package com.it.luo.utils;

/**
 * 自定义异常
 * 步骤 1.编写自定义异常类(用于做提示信息)
 *      2.编写异常处理器( 如本例中的 SysExceptionResolver)
 *      3.在spingmvc中配置异常处理器(跳转到提示页面)
 */
public class SysException extends Exception{

    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public SysException(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
