package vn.edu.likelion.player_manager_2.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_team")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamEntity extends BaseEntity {
    @Column(unique = true)
    private String name; // tên đội bóng
    @Column
    private String city; // thành phố
}
