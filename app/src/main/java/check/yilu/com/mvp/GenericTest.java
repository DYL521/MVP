package check.yilu.com.mvp;

/**
 * @author DYL
 * @date 2018/12/1.
 * email：1016068291@qq.com
 * description：
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 演示泛型 --
 */
//参考blog: https://www.cnblogs.com/lwbqqyumidi/p/3837629.html

public class GenericTest {

    public static void main(String[] args) {

//        List list = new ArrayList();
//        list.add("aa");
//        list.add("aa11");
//        list.add(100);

        List list = new ArrayList<String>();
        list.add("aa");
        list.add("aa11");
        list.add(100); //1 提示编译错误 前面指定了类型
        for (int i = 0; i < list.size(); i++) {
            String name = (String) list.get(i);
            System.out.print("name: " + name);
        }
    }
}
/**
 *  定义了一个list集合，先加入两个字符串，然后加入一个数值，这是可以的，因为这个时候默认的类型是Object
 *   但是，之后的循环中，由于没有在 list中加入Integer或者编码原因,导致编译 不出错，运行时报错：11Exception in thread "main" java.lang.ClassCastException:
 *  存在的问题:
 *    1、当我们将一个对象放入集合中, 集合并不会记住此时对象的类型; 当我们 从集合中取出对象时，该对象的 编译类型就办成
 *    了Object类型，但其运行时类型，任然为他本身
 *    2、当我们取出对象时，需要强制转换数据类型时，就出现了异常！
 *
 *    怎么解决？
 *      使集合记住集合类个 元素的类型，并且能够编译不出问题，运行也不会报错？ 那就是泛型
 */

/**
 *  什么是泛型？
 *      泛型：就是参数化类型！
 *      一提到参数，最熟悉的就是定义方法时有形参, 然后调用此方法 传递参数 。
 *      参数化类型：就是将类型由原来的具体类型参数化，类似于方法中的变量参数，此时类型 也 定义成参数形式，然后在具体使用的时候传入 具体的参数类型
 *
 */


