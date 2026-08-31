class TimeMap {
private final Map<String, List<Pair>> keyStore;
    public TimeMap() {
        keyStore=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key,k-> new ArrayList<>()).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if (!keyStore.containsKey(key)) {
    return "";
}
        List<Pair> values=keyStore.get(key);
        String result="";
        int l=0,r=values.size()-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(values.get(m).getTimestamp()<=timestamp){
                result=values.get(m).getValue();
                l=m+1;
            }
            else{r=m-1;}
        }
            return result;
    }
    private  class Pair {
        private final int timestamp;
        private final String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public String getValue() {
            return value;
        }
    }
}
