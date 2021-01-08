package easy;

/**
 * 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * 示例：
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * @author zz
 * @date 2021/1/7 14:29
 */
public class 快乐数_202 {

    /**
     * 做法：快慢指针
     * 首先分析快乐数可能的情况：为1，循环，无限下去
     * 通过数学方法可以知道，无限下去是不可能的，那就只有为1和循环两种情况
     * 如果循环，则最终一定会再次出现某个数，此时可以用判断链表是否有环的方法，为1则为快乐数
     * 慢指针一次走一步，快指针一次走两步
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int fast = getNext(n);
        int slow = getNext(getNext(n));
        while (fast != 1 && slow != 1 && fast != slow) {
            fast = getNext(fast);
            slow = getNext(getNext(slow));
        }
        if (fast == 1 || slow == 1) {
            return true;
        }
        return false;
    }

    public int getNext(int n) {
        int res = 0, tmp = 0;
        while (n != 0) {
            tmp = n % 10;
            res += tmp * tmp;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 快乐数_202().isHappy(19));
    }

}
