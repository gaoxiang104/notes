package org.gx.chapter13.p02;

public class StringBufferDemo02 {
    public static void main(String[] args) {
        String price = "12341234124.88";
        System.out.println(toScientificFormat(price));
    }

    /**
     * 科学计数
     *
     * @param in
     * @return
     */
    public static String toScientificFormat(String in) {
        if (null == in || 0 == in.length()) {
            throw new IllegalArgumentException("参数是空的");
        }

        try {
            Double.parseDouble(in);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("参数是错误，不是数值");
        }

        char[] chars = in.toCharArray();
        StringBuffer sb = new StringBuffer();
        int count = 0;
        boolean isStart = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            char ci = chars[i];

            if (isStart) {
                if (count != 0 && count % 3 == 0) {
                    sb.insert(0, ",");
                    count = 0;
                }
                count++;
            }
            if ('.' == ci) {
                isStart = true;
            }
            sb.insert(0, chars[i]);
        }

        return sb.toString();
    }
}
