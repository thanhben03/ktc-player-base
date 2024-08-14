package vn.edu.likelion.player_manager_2.Model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PlayerDTO extends BaseDTO{
    private String name;
    private String year_of_birth; // năm sinh
    private String country; // quê quán
    private int height; // chiều cao
    private float weigh; // cân nặng
    private String position; // vị trí
    private String favorable_foot; // chân thuận
    private int team_id; // thuộc team...
}
