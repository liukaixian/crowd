import com.atguigu.crowd.util.CrowdUtil;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by xian
 * Data : 2021/6/2.
 * Time : 10:00.
 */
public class test {
    @Test
    public void testMD5() {
        String md5 = CrowdUtil.md5("123123");
        System.out.println(md5);

//        byte[] bytes ={123,22,123};
//        BigInteger bigInteger = new BigInteger(1, bytes);
//        int radix = 16;
//        String encoded = bigInteger.toString(radix);
//        System.out.println(encoded);
    }

    @Test
    public void test01(){
        int i =1;
        int j =0;
        j=++i;
        System.out.println("j="+j);
    }
}