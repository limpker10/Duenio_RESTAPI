package pe.edu.tecsup.duenioapi.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Duenio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(nullable = false)
    private String Nombre;

    private Integer Edad;

    private String Direccion;

    @Column(name = "Nro_Contacto", length = 15)
    private String NroContacto;
}
