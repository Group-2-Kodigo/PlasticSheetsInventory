package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter @Setter @NoArgsConstructor @ToString

public class Material {

    @Id
    @GeneratedValue
    @Column(name = "id_material")
    private int id_material;
    @Column(name = "material")
    private String materials;
}
