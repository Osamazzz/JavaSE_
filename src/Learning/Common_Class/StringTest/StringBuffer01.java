package Learning.Common_Class.StringTest;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class StringBuffer01 {
    public static void main(String[] args) {
        // String保持的是字符串常量，里面的值不能更改，
        // 每次String类更新实际上就是更改地址，效率低,但是由于常量池的存在，它的复用率高
        // 如果需要经常对字符串进行修改，不要使用String，这样会占用大量内存，要用StringBuffer
        // StringBuffer类保存的是字符串变量，里面的值可以更改，
        // 每次StringBuffer的更新实际上可以更新内容，不用每次更改地址，效率高
        StringBuffer sb = new StringBuffer("hello");
        // StringBuffer字符内容存在char[] value中(在堆中)
        StringBuffer sb2 = new StringBuffer();//默认创建一个大小为16的char[]
        StringBuffer sb3 = new StringBuffer(100);//还可以指定大小
        //通过给一个String来创建sb，char[]大小为str.length() + 16
        StringBuffer sb4 = new StringBuffer("hello");
        sb4.append("world");//增加
        sb4.delete(0,2);//删除0-2索引的字符(不包括2)
        System.out.println(sb4);
        sb4.replace(1,5,"acb");//用acb替换索引1-4的字符
        System.out.println(sb4);
        sb4.insert(5,"abc");//在索引为5的位置插入abc，原先索引为5开始的内容往后移动
        System.out.println(sb4);
        String s = sb4.toString();//toString来返回一个字符串
        System.out.println(s);
    }
}
