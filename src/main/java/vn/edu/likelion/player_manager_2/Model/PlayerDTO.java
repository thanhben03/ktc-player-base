package vn.edu.likelion.player_manager_2.Model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PlayerDTO extends BaseDTO{
    private String name;
    private String avatar;
    private String year_of_birth; // năm sinh
    private String country; // quê quán
    private int height; // chiều cao
    private float weigh; // cân nặng
    private String position; // vị trí
    private int team_id; // thuộc team...

    private int ss; // speed
    private int bc; // ball control
    private int ls; // long sort
    private int sp; // shot power
    private double salary;
}
