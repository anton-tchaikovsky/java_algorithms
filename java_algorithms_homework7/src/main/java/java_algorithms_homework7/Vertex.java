package java_algorithms_homework7;

class Vertex{
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }

    @Override
    public String toString() {
        return String.valueOf(label);
    }
}

