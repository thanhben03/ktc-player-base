package vn.edu.likelion.player_manager_2.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_player")
@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name; // tên cầu thủ

    private String avatar;

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

//    @Column(name = "favorable_foot")
//    private String favorableFoot; // chân thuận

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private TeamEntity team; // thuộc team...

    @Column
    private double salary;

    @Column
    private int ss; // speed

    @Column
    private int bc; // ball control

    @Column
    private int ls; // long sort

    @Column
    private int sp; // shot power

}

