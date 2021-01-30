package com.igeek.shop.utils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000117607629";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCEXer23He6dx4MukMvlqWSctMYk4OX7/64tj6vj1KgUI+dHUpHWJOr3dGBrJT7fY5ndyPg4AiWI5Yn5sX8F6xHyScs+3RBtz/E6+YBppxiV9caLw2rJ7q1Cmx1hOAeXPjE8sBL9IrUjvwvZm/jnZpRzKK1KanyE90chBN+cudHtZ8WGm6095n+aZZGMOmORcIlc6fVI3G087t6XAGSP2HR6oCyRqP4Q10OK+Jdzz7cfbRg4rCbuEL29RZpdw7/ox7YWojYO3T5Tb3QYPOutjr5k5+LIFWJmGhAZ3eOBb72cTaiHgGTcOr4gQgQS4cNkEaq1I3MhWmQTtV+hdoPMsK7AgMBAAECggEABeKvKd7PrAjT2zkE9765CfP1EuisNztCli/0RZYX1G0AlbnRra5wknnAcQWdcjk49bzEaaFMgHCAorGOKBFdZau6BDQCDVH6keTzSyt/VJgXRmDFONEBaj9WZztLQ85aeVdZ2Ya8DYt2Bx2E6Bf/3pc8vNVnaw4bDMOKolq1keie9XFpuY2oufWZ6oK7g6UHchDMV7aRMrV23vsGn46b7JI0HzwtTLgyVgO03EC/yUvpUwWJ5mftarwFyAbBkFcWJ2IL2VoOn3YHxMzTALP7bIISBoOj8VWvSYlgJL4PB3zE+RN7PgasU7uA3nNNCfn6g0aQG4CdaRQugkt+NZlDYQKBgQDQTaEt+ABzZODWqKZUpH222GVEm3jmzHpW1/OtCtjsnUlt99/wQcYWCiijyio9DmAIVs6ncOURcbLcza+XaeLYx7S92LEXrKbKPxBz0wHTSbh2ltImVvljuwdRV3PKEXYOEJLX2xdvitSUfao1TLwBtbtq4HZogXMYFq8Bn69ZGQKBgQCirQf/SqL214dak3ghcWB1gWT5Oyrm3Vi/yRJFMQWD3GoxWY/yAkMG3Yel5NqX2hcd0DItBAJ5JkCZL9mZwDbUhPIdobkakw1HTiTEP5fuDprOPW1rYN0pfLU3xe0qsxlWysh0nPJ9JlpYV8EqooTO8z8kf2kPUSJorLb/soCw8wKBgFgW7DmnbnFeUOMWcTjMU0m226SW5xsbkAUX0Dn2o2P05C+4KqDM//skEqmpfhFR+fSs2TngOU8WOSC9bytmIQOx+NJsSAAOCH7xCoEg093JiFPGVlrWXyL43hBdHl9u4PDzu1XDlnaaTGn7draRm9RRSU/aWti5HbYrKZlTMXFJAoGAHlt38JY3DyVtZuO6OVN1EriQ5Um7WdXYqAGX3T2mr9LEJm12RU1SwMc6dyTb/hZ+1dtyYaAr7fvLdkrNqrmKAeLFY+44ItNqWPImPlE3wv8KuI4SC0XKP+G716qh9aPyiJXTDp/zSJONrIrDy3cEnbIbCG6WZntXln0UsWbYSS0CgYAcwW5l5hY3oeK+ZAk7BxAsGhkQJ8365ObZbYoAhk35u6QNExKWGdZKTZ2yVyceEwZ6Vnia6KI9klM9s7U240DnMYJhlHzh/mXDn9uFu6fOaFFmcQ1iJhNmePa/gLS5W+tXHwGq6insw96dmp4mDdhF7YlakSGuSsmt89TV0NyL1Q==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAg/LbqiaNiAefuo5h34EVVvCExx66IkRBVecT40xTGrvV1X8r8RoMNN7Nm7I8lM7rPRB0qWEwyq6Bz0Q+vHJwaOZoE97eNbRSxWTJljDmH+dzjxdiXA9Zwk7+pLEI8RRbWdjK9usN8Tb5R0fIbc3MXCs84xWG+7iEaEQasorZ/5zvjQncI5Uy9853FjqTw6773LV1mHinXBJzV6jaew6vfc6bw6hmqH9oYHdYIjdpVN+M8Ui9tHzB3npjaB913M/BIvmmSez6v3YKdLds+A8gzlqaWUxzngolDG+FkcIWmR4D12DCKQk5zxv4DAUjFw1O1lmxAiIvWRXLrjbSulYehQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://igeekshop.free.idcfengye.com/shop/notify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://igeekshop.free.idcfengye.com/shop/pages/alipay/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

