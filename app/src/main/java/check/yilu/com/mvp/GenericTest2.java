package check.yilu.com.mvp;

/**
 * @author DYL
 * @date 2018/12/1.
 * email：1016068291@qq.com
 * description：
 */
public class GenericTest2 {

    public static void main(String[] args) {

        Box<String> name = new Box<String>("corn");
        Box<Integer> name2 = new Box<Integer>(1122345);

        System.out.println("name:" + name.getData());
        System.out.println("name2:" + name2.getData());
    }

    static class Box<T> {

        private T data;

        public Box() {

        }

        public Box(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}

/**
 * 由此，我们发现，在使用泛型类时，虽然传入了不同的泛型实参，但并没有真正意义上生成不同的类型，传入不同泛型实参的泛型类在内存上只有一个，
 * 即还是原来的最基本的类型（本实例中为Box），当然，在逻辑上我们可以理解成多个不同的泛型类型。
 *
 * 究其原因，在于Java中的泛型这一概念提出的目的，导致其只是作用于代码编译阶段，在编译过程中，
 * 对于正确检验泛型结果后，会将泛型的相关信息擦出，也就是说，成功编译过后的class文件中是不包含任何泛型信息的。泛型信息不会进入到运行时阶段。

 * 对此总结成一句话：泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
 */

