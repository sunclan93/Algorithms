//String val = "";
//        int cursor = 0;
//        int a = 0;
//        int b = 0;
//        String clipboard = "";
//        boolean isSelect = false;
//        int pointer = 0;
//        void paste() {
//        if (isSelect) {
//        delete();
//        append(clipboard);
//        System.out.println(val);
//        }
//        else {
//        append(clipboard);
//        System.out.println(val);
//        }
//        }
//        void copy() {
//        if (isSelect){
//        clipboard = val.substring(a, b);
//        return;
//        }
//        else  {
//        return;
//        }
//        }
//        void append(String str) {
//        if (isSelect) {
//        val = val.substring(0, a) + val.substring(b, val.length());
//        isSelect = false;
//        cursor = a;
//        append(str);
//        System.out.println(str);
//        }
//        else {
//        if (val.length() == 0) {
//        val = str;
//        cursor = str.length();
//        // System.out.println(val);
//        return;
//        }
//        String res = val.substring(0, cursor) +
//        str +
//        val.substring(cursor, val.length());
//        cursor = cursor + str.length();
//        val = res;
//        // System.out.println(val);
//        }
//        }
//        void move(String point) {
//
//        int p = Integer.parseInt(point);
//        if (p < 0) cursor = 0;
//        else if (p > val.length()) cursor = val.length();
//        else cursor = p;
//        isSelect = false;
//        // System.out.println(val);
//        }
//
//        void select(String l, String r) {
//        int left = Integer.parseInt(l);
//        int right = Integer.parseInt(r);
//        System.out.println(left + "  "+ right);
//        System.out.println("length: " + val.length());
//        if (left > right) return;
//        if (left == right) {
//        move(left+"");
//        return;
//        }
//        if (left < 0) {
//        a = 0;
//        }
//        else if (left > val.length()) {
//        a = val.length();
//        }
//        else {
//        a = left;
//        }
//        if (right < 0) {
//        b = 0;
//        }
//
//        else if (right > val.length()) {
//        b = val.length();
//        }
//        else {
//        b = right;
//        }
//
//
//        isSelect = true;
//        System.out.println(this.a+"  "+this.b);
//        System.out.println(val);
//        // System.out.println(val);
//        }
//        void delete() {
//
//        if (cursor == 0) return;
//        if (val.length() == 0) return;
//        if (isSelect) {
//        val = val.substring(0, a) + val.substring(b, val.length());
//        isSelect = false;
//        cursor = a;
//        }
//        else {
//        if (cursor == val.length()) {
//        val = val.substring(0, cursor - 1);
//        cursor--;
//        }
//        else {
//        val = val.substring(0, cursor - 1) + val.substring(cursor, val.length());
//        cursor--;
//        }
//        }
//        // val = val.substring(0, cursor) + val.substring(cursor + 1, val.length());
//        // System.out.println(val);
//        }
//        Stack<String> stack = new Stack<>();
//        void check(String[] res) {
//
//        if (res.length == 0) return;
//        int le = res.length - 1;
//        if (res.length == 1) {
//        stack.push(res[1]);
//        }
//
//        else {
//        if (!res[le].equals(res[le - 1]) && res[le].equals(stack.peek())) {
//
//        stack.push(res[le]);
//        }
//        }
//        }
//        String[] solution(String[][] queries) {
//        String[] res = new String[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//        if (queries[i][0].equals("APPEND")) {
//        append(queries[i][1]);
//        res[i]=val;
//        check(res);
//        }
//        if (queries[i][0].equals("MOVE")) {
//        move(queries[i][1]);
//        res[i]=val;
//        check(res);
//        }
//        if  (queries[i][0].equals("BACKSPACE")) {
//        delete();
//        res[i] = val;
//        check(res);
//        }
//        if (queries[i][0].equals("SELECT")) {
//        select(queries[i][1], queries[i][2]);
//        res[i] = val;
//        check(res);
//        }
//        if (queries[i][0].equals("COPY")) {
//        copy();
//        res[i] = val;
//        check(res);
//        }
//        if (queries[i][0].equals("PASTE")) {
//        paste();
//        res[i] = val;
//        check(res);
//        }
//        if (queries[i][0].equals("UNDO")) {
//        check(res);
//        }
//
//        }
//        return res;
//        }
