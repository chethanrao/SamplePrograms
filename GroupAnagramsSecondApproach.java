import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
/*
Given an array of strings, group anagrams together.
For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:
[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/
/*2nd approach*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      
        
        
        
        Map<Map<Character,Integer>,List<String>> freqMap=new HashMap<Map<Character,Integer>,List<String>>();
        
        
        
        for (String str:strs){
            HashMap<Character,Integer> hashMap=getHashMapFromString(str);
            if (!freqMap.containsKey(hashMap)){
                 List<String> newList=new ArrayList<String>();
                 newList.add(str);
                freqMap.put(hashMap,newList);
            }
            else {
                List<String> exisitingList=freqMap.get(hashMap);
                exisitingList.add(str);

                freqMap.put(hashMap,exisitingList);

            }
            
        }

        List<List<String>> finallist=new ArrayList<List<String>>();
        for (List<String> anagramlist:freqMap.values()){
          
            
            finallist.add(anagramlist);
            
        }
        
        return finallist;
        
        
    }
    
    HashMap<Character,Integer> getHashMapFromString(String str){
        HashMap<Character,Integer> hashMap=new HashMap<Character,Integer>();

        for (int i=0;i<str.length();i++){
            if (hashMap.containsKey(str.charAt(i))){
                int freq=hashMap.get(str.charAt(i));
                
                hashMap.put(str.charAt(i),freq+1);
                
            }
            else {
                 hashMap.put(str.charAt(i),1);

            }
        }
             return hashMap;

    }
    
    
  
    
}
