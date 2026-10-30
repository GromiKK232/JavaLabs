class StringLengthCondition implements Condition<String> {
    private final String name;

    public StringLengthCondition(String name) { 
        this.name = name; 
    }

    @Override 
    public boolean test(String value) { 
        if (value.length() >= 3) {
            return true;  
        } 
        else {
            return false; 
        }
    }

    @Override 
    public String toString() { 
        return name; 
    }
}

class NegativeNumberCondition implements Condition<Integer> {
    private final String name;

    public NegativeNumberCondition(String name) { 
        this.name = name; 
    }

    @Override 
    public boolean test(Integer value) { 
        if (value <= 0) {
            return true;  
        } 
        else {
            return false; 
        }
    }

    @Override 
    public String toString() { 
        return name; 
    }
}

class NoPositiveElementsCondition implements Condition<int[]> {
    private final String name;

    public NoPositiveElementsCondition(String name) { 
        this.name = name; 
    }

    @Override 
    public boolean test(int[] array) {
        if (array == null) {
            return false;
        }
        for (int num : array) { 
            if (num > 0) {
                return false; 
            } 
        }
        return true; 
    }

    @Override 
    public String toString() { 
        return name; 
    }
}
