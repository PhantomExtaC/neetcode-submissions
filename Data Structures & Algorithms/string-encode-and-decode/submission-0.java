class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();

        for (String s : strs) {
            encodedString.append(s.length()).append('#').append(s);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrs = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int delimiterIndex = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, delimiterIndex));

            int stringStart = delimiterIndex + 1 ;
            int stringEnd = stringStart +length;

            decodedStrs.add(str.substring(stringStart, stringEnd));

            i = stringEnd;
        }
        return decodedStrs;
    }
}
