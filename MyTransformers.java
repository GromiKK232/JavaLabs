class StringLengthTransformer implements Transformer<String, Integer> {
    private final String name;

    public StringLengthTransformer(String name) { 
        this.name = name; 
    }

    @Override 
    public Integer apply(String value) { 
        return value.length(); 
    }

    @Override 
    public String toString() { 
        return name; 
    }
}

class AbsoluteValueTransformer implements Transformer<Integer, Integer> {
    private final String name;

    public AbsoluteValueTransformer(String name) { 
        this.name = name; 
    }

    @Override 
    public Integer apply(Integer value) { 
        if (value < 0) {
            return -value; 
        } else {
            return value;  
        }
    }

    @Override 
    public String toString() { 
        return name; 
    }
}

class ArrayMaxTransformer implements Transformer<int[], Integer> {
    private final String name;

    public ArrayMaxTransformer(String name) { 
        this.name = name; 
    }

    @Override 
    public Integer apply(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];
        for (int num : array) { 
            if (num > max) {
                max = num; 
            }
        }
        return max;
    }

    @Override 
    public String toString() { 
        return name; 
    }
}
