package figure;

/**
 * Created by Simannom on 24.06.2018.
 */
public class Node {
    private double x;
    private double y;

    public Node(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Node (Node tmp){
        this.x = tmp.x;
        this.y = tmp.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance (Node other){
        return Math.sqrt( Math.pow(this.x - other.x,2) + Math.pow(this.y - other.y,2));
    }

    public void add(Node a, Node b){
        this.x = a.x + b.x;
        this.y = a.y + b.y;
    }

    public void add (Node a){
        this.x += a.x;
        this.y += a.y;
    }

    public void substract(Node a, Node b){
        this.x = a.x + b.x;
        this.y = a.y + b.y;
    }

    public void substract(Node a){
        this.x += a.x;
        this.y += a.y;
    }

    public void mult(double mult){
        this.x *= mult;
        this.y *= mult;
    }

    public Node multiply (double mult){
        Node tmp = new Node(0,0);
        tmp.x = this.x * mult;
        tmp.y = this.y * mult;
        return tmp;
    }
}
