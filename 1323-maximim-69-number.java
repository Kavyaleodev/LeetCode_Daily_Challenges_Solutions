class Solution {
    public int maximum69Number(int num) {
        int t = num, first, second, third, four, tem, res = 0;
        if (num > 999) {
            first = 9 * 1000 + t % 1000;
            tem = t % 100;
            t /= 1000;
            second = t * 1000 + 9 * 100 + tem;
            t = num;
            tem = t % 10;
            t /= 100;
            third = t * 100 + 9 * 10 + tem;
            t = num;
            t /= 10;
            four = t * 10 + 9;
            res = Math.max(num, Math.max(first, Math.max(second, Math.max(third, four))));
        } else if (num > 99 && num < 1000) {
            first = 9 * 100 + t % 100;
            tem = t % 10;
            t /= 100;
            second = t * 100 + 9 * 10 + tem;
            t = num;
            t /= 10;
            third = t * 10 + 9;
            res = Math.max(num, Math.max(first, Math.max(second, third)));
        } else if (num > 9 && num < 100) {
            first = 9 * 10 + t % 10;
            t /= 10;
            second = t * 10 + 9;
            res = Math.max(num, (Math.max(first, second)));
        } else if (num > 0) {
            res = 9;
        }
        return res;
    }
}