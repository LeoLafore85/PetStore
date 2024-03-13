package pet;

import jakarta.persistence.*;
@Entity
@Table(name = "CAT")
public class Cat extends Animal {

    @Column(name = "chip_id", nullable = false, unique = true)
    private String chipId;

    public String getChipId() { return chipId; }
    public void setChipId(String chipId) { this.chipId = chipId; }
}
