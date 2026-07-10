class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Create the frequency array for the current string
            int[] charCounts = new int[26];
            for (char c : s.toCharArray()) {
                charCounts[c - 'a']++;
            }
            
            // Transform the array into a string to use as a HashMap key
            StringBuilder signatureBuilder = new StringBuilder();
            for (int count : charCounts) {
                signatureBuilder.append('#');
                signatureBuilder.append(count);
            }
            String signature = signatureBuilder.toString();
            
            // If the signature isn't in the map yet, add it with an empty list
            if (!map.containsKey(signature)) {
                map.put(signature, new ArrayList<>());
            }
            
            // Add the original string to the corresponding list
            map.get(signature).add(s);
        }
        
        // Return all the grouped lists
        return new ArrayList<>(map.values()); 
    }
}
