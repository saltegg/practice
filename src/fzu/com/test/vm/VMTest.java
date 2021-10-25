package fzu.com.test.vm;

// StringTable["a"]
public class VMTest {
    // 常量池中的信息，都会被加载到运行时常量池中，这是a b ab都是常量池中的符号，还不是Java对象
    // ldc #2 会把a符号变为“a”字符串对象

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2; // new StringBuilder().append("a").append("b").toString()
        String s5 = "a" + "b"; // javac 在编译期间的优化，结果已经在编译器确定为ab
        String s = new String("a") + new String("b");
        // "a"是常量被放入串池，"b"也同样； new String("a")新创建的对象在堆种，值也为“a”，但对象不是同一个

    }
}
