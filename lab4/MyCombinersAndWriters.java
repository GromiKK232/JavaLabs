import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class StringConcatCombiner implements Combiner<String> {
    private final String name;
    public StringConcatCombiner(String name) { this.name = name; }
    @Override 
    public String combine(String left, String right) {
         return left + right;
    }

    @Override 
    public String toString() {
         return name; 
    }
}

class IntegerSumCombiner implements Combiner<Integer> {
    private final String name;
    public IntegerSumCombiner(String name) { this.name = name; }
    @Override 
    public Integer combine(Integer left, Integer right) { 
        return left + right; 
    }

    @Override public String toString() {
         return name; 
    }
}

class NumberSplitWriter implements ResultWriter<List<List<Integer>>, Integer> {
    private final String name;
    public NumberSplitWriter(String name) { this.name = name; }
    @Override public void add(List<List<Integer>> result, Integer value) {
        if (value >= 0) result.get(0).add(value); 
        else result.get(1).add(value);
    }

    @Override 
    public String toString() { 
        return name; 
    }
}

class StringGroupWriter implements ResultWriter<Map<Integer, List<String>>, String> {
    private final String name;
    public StringGroupWriter(String name) { this.name = name; }
    @Override public void add(Map<Integer, List<String>> result, String value) {
        int len = value.length();
        if (!result.containsKey(len)) result.put(len, new ArrayList<>());
        result.get(len).add(value);
    }

    @Override 
    public String toString() { 
        return name; 
    }
}

class StringSetWriter implements ResultWriter<Set<String>, String> {
    private final String name;
    public StringSetWriter(String name) { this.name = name; }

    @Override 
    public void add(Set<String> result, String value) { 
        result.add(value); 
    }

    @Override 
    public String toString() {
         return name; 
    }
}
