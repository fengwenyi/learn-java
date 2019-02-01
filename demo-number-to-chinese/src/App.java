/**
 * App
 * @author Wenyi Feng
 * @since 2019-02-01
 */
public class App {

    public static void main(String[] args) {
        String a = "支付宝到账";
        String b = "元";
        String rs = NumberToChinese.getOutput(20001 + "");
        System.out.println(a + " " + rs + " " + b);
    }

}
