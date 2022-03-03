package Algorithms.Lintcode.DataStructure;

public class Solution {

    String clipboard = "";
    String val="";
    int cursor = 0;
    int a = 0;
    int b = 0;
    int pointer = -1;
    boolean isSelect = false;
    public void undo(){
        if (pointer == -1 ){
            return;
        }

    }
    public void paste() {
        if (isSelect) {
            delete();
            append(clipboard);
            System.out.println(val);
        }
        else {
            append(clipboard);
            System.out.println(val);
        }
    }
    public void copy() {
        if (isSelect){
            clipboard = val.substring(a, b);
            return;
        }
        else  {
            return;
        }
    }
    public void append(String str) {
        if (isSelect) {
            val = val.substring(0, a) + val.substring(b, val.length());
            isSelect = false;
            cursor = a;
            append(str);
            System.out.println(str);
        }
        else {
            if (val.length() == 0) {
                val = str;
                cursor = str.length();
                // System.out.println(val);
                return;
            }
            String res = val.substring(0, cursor) +
                    str +
                    val.substring(cursor, val.length());
            cursor = cursor + str.length();
            val = res;
            System.out.println(val);
        }

    }
    public void select(String l, String r) {
        int left = Integer.parseInt(l);
        int right = Integer.parseInt(r);
        System.out.println(left + "  "+ right);
        System.out.println("length: " + val.length());
        if (left > right) return;
        if (left == right) {
            move(left+"");
            return;
        }
        if (left < 0) {
            a = 0;
        }
        else if (left > val.length()) {
            a = val.length();
        }
        else {
            a = left;
        }
        if (right < 0) {
            b = 0;
        }

        else if (right > val.length()) {
            b = val.length();
        }
        else {
            b = right;
        }


        isSelect = true;
        System.out.println(this.a+"  "+this.b);
        System.out.println(val);
    }
    public void delete() {
        if (cursor == 0) return;
        if (val.length() == 0) return;
        if (isSelect) {
            val = val.substring(0, a) + val.substring(b, val.length());
            isSelect = false;
            cursor = a;

        }
        else{
            val = val.substring(0, cursor) + val.substring(cursor + 1, val.length());
            System.out.println(val);
        }

    }
    public void move(String point) {
        int p = Integer.parseInt(point);
        cursor = p;
        System.out.println(val);
    }
    public void solution() {
        append("You'll never find a rainbow if you're looking down");
        select("6","50");
        delete();
        System.out.println(val);
//        copy();
//        paste();
//        paste();
//
//        delete();
//        append(",");
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.solution();

//        String s = "1234";
//        String abs = s.substring(s.length(), s.length());
//        System.out.println(abs);
    }
}
