package addtwonumbers;

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carryover = false;

        int sum = l1.val + l2.val;

        if (sum >= 10) {
            sum -= 10;
            carryover = true;
        } else
            carryover = false;

        ListNode result = new ListNode(sum);
        ListNode cursor1 = l1.next;
        ListNode cursor2 = l2.next;
        ListNode cursorResult = result;

        while (cursor1 != null && cursor2 != null) {
            sum = cursor1.val + cursor2.val;

            if (carryover)
                ++sum;
            if (sum >= 10) {
                sum -= 10;
                carryover = true;
            } else
                carryover = false;

            cursorResult.next = new ListNode(sum);

            cursor1 = cursor1.next;
            cursor2 = cursor2.next;
            cursorResult = cursorResult.next;
        }

        while (cursor1 != null) {
            sum = cursor1.val;
            if (carryover)
                ++sum;
            if (sum >= 10) {
                sum -= 10;
                carryover = true;
            } else
                carryover = false;
            cursorResult.next = new ListNode(sum);
            cursor1 = cursor1.next;
            cursorResult = cursorResult.next;
        }

        while (cursor2 != null) {
            sum = cursor2.val;
            if (carryover)
                ++sum;
            if (sum >= 10) {
                sum -= 10;
                carryover = true;
            } else
                carryover = false;
            cursorResult.next = new ListNode(sum);
            cursor2 = cursor2.next;
            cursorResult = cursorResult.next;
        }

        if (carryover)
            cursorResult.next = new ListNode(1);

        return result;
    }

    public static int listNodeToInt(ListNode node) {
        int result = node.val;
        int mult = 10;
        node = node.next;
        while (node != null) {
            result = result * mult + node.val;
            node = node.next;
            mult *= 10;
        }
        return result;
    }

    public static int listNodeToIntReverse(ListNode node) {
        int result = node.val;
        int mult = 10;
        node = node.next;
        while (node != null) {
            result = result + node.val * mult;
            node = node.next;
            mult *= 10;
        }
        return result;
    }

    public static ListNode intToListNode(int number) {
        ListNode head = new ListNode(number % 10), tmp = head;
        number /= 10;
        while (number > 0) {
            head = new ListNode(number % 10);
            head.next = tmp;
            tmp = head;
            number /= 10;
        }
        return head;
    }

    public static ListNode intToListNodeReverse(int number) {
        ListNode head = new ListNode(number % 10), tmp = head;
        number /= 10;
        while (number > 0) {
            tmp.next = new ListNode(number % 10);
            tmp = tmp.next;
            number /= 10;
        }
        return head;
    }

    public static ListNode addTwoNumbersToInt(ListNode l1, ListNode l2) {
        int a = listNodeToInt(l1);
        int b = listNodeToInt(l2);
        return intToListNode(a + b);
    }

    public static void main(String[] args) {
        ListNode tmp, l1 = new ListNode(2), l2 = new ListNode(5);
        tmp = l1;
        tmp.next = new ListNode(4);
        tmp = tmp.next;
        tmp.next = new ListNode(3);

        tmp = l2;
        tmp.next = new ListNode(6);
        tmp = tmp.next;
        tmp.next = new ListNode(4);

        tmp = Solution.addTwoNumbers(l1, l2);
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
}
