package com.negen;

import com.negen.test.DynamicProxyTestAutoBoxing;
import com.negen.test.ITestAutoBoxing;
import com.negen.test.TestAutoBoxing;
import net.bytebuddy.asm.Advice;

import java.util.*;

/**
 * @author ：Negen
 * @Date ：Created in 16:08 2020/4/16
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
public class Test{
    public static void main(String[] args) {
        ITestAutoBoxing testAutoBoxing = (ITestAutoBoxing)new DynamicProxyTestAutoBoxing().bind(new TestAutoBoxing());
        testAutoBoxing.LongSum();
        testAutoBoxing.longSum();
    }

}
