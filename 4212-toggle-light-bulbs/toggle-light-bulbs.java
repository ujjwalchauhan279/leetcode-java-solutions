class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x: bulbs){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        for(int x: map.keySet()){
            if(map.get(x) % 2 != 0){
                list.add(x);
            }
        }

        Collections.sort(list);
        return list;
    }
}