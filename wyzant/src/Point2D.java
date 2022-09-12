class Point2D
{
    private int x;
    private int y;

    public Point2D()
    {
        this.x = 0;
        this.y = 0;
    }

    public Point2D(int _x, int _y)
    {
        this.x = _x;
        this.y = _y;
    }

    public void move(int dx, int dy)
    {
        this.x += dx;
        this.y += dy;
    }

    public void moveTo(int new_x, int new_y)
    {
        this.x = new_x;
        this.y = new_y;
    }

    public String toString()
    {
        return "(" + this.x + ", " + this.y + ")";
    }
}
