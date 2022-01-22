package com.quan.myblog.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Commons
 * @Description: 公共函数
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/22 9:59
 */

@Component
public class Commons {

    /**
     * @Author Hilda
     * @Description //TODO 转换UNIX日期格式
     * @Date 10:08 2022/1/22
     * @Param [unixTime, patten]
     * @returnValue java.lang.String
     **/
    public static String fmtdate(Integer unixTime, String patten) {
        // 数据验证
        if (null != unixTime && StringUtils.isNotBlank(patten)) {
            return DateKit.formatDateByUnixTime(unixTime, patten);
        }
        
        return "";
    }
    
    
    /**
     * @Author Hilda
     * @Description //TODO 处理url，并返回合适的url
     * @Date 16:05 2022/1/22
     * @Param [url]
     * @returnValue java.lang.String
     **/
//    public static String site_url(String url) {
//
//    }

}
