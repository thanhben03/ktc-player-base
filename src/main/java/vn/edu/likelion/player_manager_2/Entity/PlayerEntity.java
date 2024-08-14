package vn.edu.likelion.player_manager_2.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_player")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity extends BaseEntity {
    @Column(unique = true,nullable = false)
    private String name; // tên cầu thủ

    @Column(name = "year_of_birth", nullable = false)
    private String yearOfBirth; // năm sinh

    @Column
    private String country; // quê quán

    @Column
    private int height; // chiều cao

    @Column
    private float weigh; // cân nặng

    @Column
    private String position; // vị trí

    @Column(name = "favorable_foot")
    private String favorableFoot; // chân thuận

    @Column(name = "team_id")
    private int teamId; // thuộc team...
}

