package com.zykj.phmall.beans;

/**
 * Created by csh
 * Created date 2016/9/24.
 * Description 预存款账户
 */

public class FundBean {
    //账户余额
    public String lg_av_amount;//账户余额
    public String lg_add_time;//记录时间
    public String lg_desc;//当前说明
    //充值明细
    public String pdr_amount;//充值金额
    public String pdr_payment_name;//充值记录
    public String pdr_add_time;//充值时间
    //余额提现
    public String pdc_amount;//提现金额
    public String pdc_add_time;//提现时间
    public String pdc_bank_no;//银行卡号
}