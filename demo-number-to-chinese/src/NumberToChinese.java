
/**
 * 显示数字的汉字读法，如：1234，读作：一千二百三十四
 * @author Wenyi Feng
 * @since 2019-02-01
 */
public class NumberToChinese {

    // 单个数字中文表示
    private static final String [] numbers =
            {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};

    private static final String [] units =
            {"", "十", "百", "千", "万", "十", "百", "千", "亿"};// 单位

    /**
     * <p> 输入一串数字，显示汉字读法的方法</p>
     *
     * @param input
     * @return String
     */
    public static String getOutput(String input) {
        if (input.length() > 9) {
            return "最多输入9位数字";
        }
        StringBuilder sb = new StringBuilder();
        int back;
        // 将数字字符串串中的每个数字字符按照从左到右的顺序放入数组
        String [] result;
        result = new String[input.length()];// result数组初始化
        for (int i = 0; i < result.length; i++) {
            result[i] = String.valueOf(input.charAt(i));
        }

        for (int i = 0; i < result.length; i++) {
            if (!result[i].equals("0")) {
                back = result.length - i - 1;

                sb.append(numbers[Integer.parseInt(result[i])]);

                sb.append(units[back]);
            } else {
                if (i == result.length - 5 && result[i].equals("0")) {
                    if (result.length == 9 &&
                            result[1].equals("0") &&
                            result[2].equals("0") &&
                            result[3].equals("0")) {
                        sb.append(numbers[0]);
                    } else {
                        sb.append(units[4]);
                    }
                } else {
                    if (i < result.length - 1 && !result[i + 1].equals("0")) {
                        sb.append(numbers[0]);
                    }
                }
            }
        }
        return sb.toString();
    }

}
