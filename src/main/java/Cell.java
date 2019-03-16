import java.util.Objects;

public class Cell {

    private short x,y,z;
    private long id;

    public Cell(short x, short y, short z, long id) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.id = id;
    }

    public short getX() {
        return x;
    }

    public void setX(short x) {
        this.x = x;
    }

    public short getY() {
        return y;
    }

    public void setY(short y) {
        this.y = y;
    }

    public short getZ() {
        return z;
    }

    public void setZ(short z) {
        this.z = z;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y &&
                z == cell.z &&
                id == cell.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, id);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", id=" + id +
                '}';
    }

}
