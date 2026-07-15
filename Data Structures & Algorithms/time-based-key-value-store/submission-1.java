class TimeMap {
    private static class item {
        public int timestamp;
        public String value;
        public item(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<item>> map; 

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<item> itemList;
        if (!map.containsKey(key)) {
            itemList = new ArrayList<>();
        } else {
            itemList = map.get(key);
        }
        itemList.add(new item(timestamp, value));
        map.put(key, itemList);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<item> itemList = map.get(key);
        int left = 0, right = itemList.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (itemList.get(mid).timestamp == timestamp) {
                return itemList.get(mid).value;
            } else if (itemList.get(mid).timestamp < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right >= 0 ? itemList.get(right).value : "";
    }
}
