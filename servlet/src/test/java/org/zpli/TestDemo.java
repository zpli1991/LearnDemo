package org.zpli;

import org.junit.Test;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/4/15 17:51
 */
public class TestDemo {

    @Test
    public void tst(){
        String str ="{\"Author\":\"银企通\",\"Cron\":\"0 15 8 15 4 ? 2020\",\"FailRetryCount\":0,\"Id\":0,\"JobDesc\":\"推送打卡提醒\"," +
                "\"MethodName\":\"pushClockReminder\",\"Param\":{\"isOnWorkReminder\":true,\"reminderTime\":1586910600," +
                "\"cpyIds\":[2017243605,2017243606,2017243607,2017243600,2017243601,2017243602,2017243603,2017243596,2017243597,2017243598," +
                "2017243599,2017243592,2017243593,2017243594,2017243595,2017243588,2017243589,2017243590,2017243591,2017243584,2017243585," +
                "2017243586,2017243587,2017243708,2017243709,2017243710,2017243711,2017243704,2017243705,2017243706,2017243707,2017243700," +
                "2017243701,2017243702,2017243703,2017243696,2017243697,2017243698,2017243699,2017243692,2017243693,2017243694,2017243695," +
                "2017243688,2017243689,2017243690,2017243691,2017243684,2017243685,2017243686,2017243687,2017243680,2017243681,2017243682," +
                "2017243683,2017243676,2017243677,2017243678,2017243679,2017243672,2017243673,2017243674,2017243675,2017243668,2017243669," +
                "2017243670,2017243671,2017243664,2017243665,2017243666,2017243667,2017243660,2017243661,2017243662,2017243663,2017243656," +
                "2017243657,2017243658,2017243659,2017243652]},\"Path\":\"funServer\",\"ServiceName\":\"clockReminder\"}";

        System.out.println(str.length());
    }
}
