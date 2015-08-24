package pro.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coordinates")
public class Coordinate {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "nick")
    private String nick;

    @Column(name = "coordinate_x")
    private Double coordinate_x;

    @Column(name = "coordinate_y")
    private Double coordinate_y;

    public Coordinate (){}

    public Coordinate(String nick, Double coordinate_x, Double coordinate_y){
        this.nick = nick;
        this.coordinate_x = coordinate_x;
        this.coordinate_y = coordinate_y;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Double getCoordinate_x() {
        return coordinate_x;
    }

    public void setCoordinate_x(Double coordinate_x) {
        this.coordinate_x = coordinate_x;
    }

    public Double getCoordinate_y() {
        return coordinate_y;
    }

    public void setCoordinate_y(Double coordinate_y) {
        this.coordinate_y = coordinate_y;
    }

}
