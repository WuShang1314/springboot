package cn.lzy.service09.Service1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/23 17:56
 * @Version 1.0
 */
public class DataUtils {
    public final static String data1="yyyy-MM-dd HH:mm:ss";
    public final static String data2="yyyy-MM-dd ";
    public static String getData(String dataType){
        Date day=new Date();
        SimpleDateFormat lnb=new SimpleDateFormat(dataType);
        return lnb.format(day);
    }
}
