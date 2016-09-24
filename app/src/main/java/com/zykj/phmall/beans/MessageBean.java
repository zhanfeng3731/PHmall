package com.zykj.phmall.beans;

/**
 * Created by csh
 * Created date 2016/9/23.
 * Description 消息
 */

public class MessageBean {
    public String message_id;//消息Id
    public String message_parent_id;//父Id
    public String from_member_id;//发布者Id
    public String to_member_id;//接受这Id
    public String message_title;//消息标题
    public String message_body;//消息内容
    public String message_time;//发送时间（Long）
    public String message_update_time;//修改时间（Long）
    public String message_open;//消息打开
    public String message_state;//消息状态
    public String message_type;//消息类型
    public String read_member_id;//阅读者Id
    public String del_member_id;//删除这Id
    public String message_ismore;//更多
    public String from_member_name;//发送者昵称
    public String to_member_name;//接受者昵称
    public String url_type;//类型member_order(订单)/member_return(订单退款)/member_fund(余额)/member_refund(订单退货)
}