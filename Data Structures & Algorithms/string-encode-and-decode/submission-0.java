class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(String.valueOf(str.length()));
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while(index < str.length()) {
            StringBuilder lengthStr = new StringBuilder();
            while(str.charAt(index) != '#') {
                lengthStr.append(str.charAt(index++));
            }
            int length = Integer.parseInt(lengthStr.toString());
            index++;
            StringBuilder temp = new StringBuilder();
            int count = 0;
            while (count < length) {
                temp.append(str.charAt(index++));
                count++;
            }
            res.add(temp.toString());
        }
        return res;
    }
}
