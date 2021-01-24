package com.igeek.shop.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
/**
 * @author ：Allen
 * @date ：Created in 2021/1/15 18:02
 * @description：
 * @version: 1.0
 */
public class WebUtils {
    static {

        class DateConvert implements Converter {

            @Override
            public <T> T convert(Class<T> aClass, Object o) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", new DateFormatSymbols(Locale.CHINA));
                try {
                    return (T) sdf.parse((String) o);
                } catch (ParseException e) {
//                        e.printStackTrace();
                }
                return null;
            }
        }

        ConvertUtils.register(new DateConvert()
        , Date.class);
    }

    public static <T> T parseMapToBean(T obj, Map map){
        try {
            BeanUtils.populate(obj,map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }
    public static Integer parseStr2Int(String str,Integer defaultValue){
           int i;
        try{
           i = Integer.parseInt(str);
        }catch (Exception e){
            i = defaultValue;
        }
        return i;
    }
}
