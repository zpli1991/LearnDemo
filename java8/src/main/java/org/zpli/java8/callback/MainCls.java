package org.zpli.java8.callback;

/**
 * @Description: 函数调用类
 * @author: zpli
 * @Date: 2020/3/19 15:38
 */
public class MainCls {

    public static void main(String[] args) {
        Immortal tieGuaili = new Immortal("铁拐李");
        // 不使用lambda表达式
        tieGuaili.crossingSea(new Magic() {
            @Override
            public void doMagic() {
                System.out.print("骑着葫芦");
            }
        });
        // 使用lambda表达式
        // tieGuaili.crossingSea(() -> System.out.print("骑着葫芦"));

        Immortal zhangGuoLao  = new Immortal("张果老");
        zhangGuoLao.crossingSea(() -> System.out.print("骑着毛驴"));

        Immortal heXianGu  = new Immortal("何仙姑");
        heXianGu.crossingSea(() -> System.out.print("踩着荷叶"));

        Immortal hanXiangzi  = new Immortal("韩湘子");
        hanXiangzi.crossingSea(() -> System.out.print("用笛子变成浮木"));

        Immortal liDongBin  = new Immortal("吕洞宾");
        liDongBin.crossingSea(() -> System.out.print("踩着宝剑"));

        Immortal lanCaiHe  = new Immortal("蓝采和");
        lanCaiHe.crossingSea(() -> System.out.print("坐着花篮"));

        Immortal hanZhongLi  = new Immortal("汉钟离");
        hanZhongLi.crossingSea(() -> System.out.print("使用芭蕉扇"));

        Immortal caoGuoJiu  = new Immortal("曹国舅");
        caoGuoJiu.crossingSea(() -> System.out.print("使用阴阳玉板"));
    }
}
