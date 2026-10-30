public class Line<T extends Point2D> {
    private T start;
    private T end;

    public Line(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public T getStart() { 
        return start; 
    }
    
    public T getEnd() { 
        return end; 
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
