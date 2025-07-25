class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        if (s.length() == 1) {
            return map.get(s);
        }

        int out = 0;
        Boolean loop = false;

        for (int i = 0; i < s.length() - 1; i++) {
            int first = map.get(s.substring(i, i+1));
            int second = map.get(s.substring(i+1, i+2));

            if (first >= second) {
                if (loop == false) {
                    out += first;
                    System.out.println("First");
                }               
                if (i == (s.length() - 2)) {
                    System.out.println("Expos");
                    out += second;
                }
            } else if (second > first) {
                String combo = s.substring(i, i+2);
                i += 1;
                if (i == (s.length() - 2)) {
                    i -= 1;
                    loop = true;
                }
                System.out.println("Second " + first + ", " + second);
                out += map.get(combo);
            }
        }
        return out;
    }
}