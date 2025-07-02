package 字符串;

public class Z字型变换 {
    /*
    找出规律公式
     */
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int m = (s.length() + numRows - 2) / (numRows - 1);
        int n = numRows ;
        int len = s.length() - 1;
        char[] res = new char[s.length()];
        int index = 0;
        int cur = 0;
        for(int j=0;j<m;j++){
            cur = 2*j*(n-1);
            if (cur <= len && cur >= 0)
                res[index++] = s.charAt(cur);
        }

        for(int i=1;i<n-1;i++){
            for(int j=0;j<m;j++){
                cur = 2*j*(n-1)-i;
                if (cur <= len && cur >= 0)
                    res[index++] = s.charAt(cur);

                cur = 2*j*(n-1)+i;
                if (cur <= len && cur >= 0)
                    res[index++] = s.charAt(cur);
            }
        }

        for(int j=0;j<m;j++){
            cur = (2*j+1)*(n-1);
            if (cur <= len && cur >= 0)
                res[index++] = s.charAt(cur);
        }
        return new String(res);
    }
}
