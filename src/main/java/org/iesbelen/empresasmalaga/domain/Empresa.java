package org.iesbelen.empresasmalaga.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Empresa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String nombre;
    //LONGTEXT permite almacenar muchos caracteres.
    @Column(name = "descripcion", columnDefinition = "LONGTEXT")
    private String descripcion;
    private String direccion;
    private String img;
    private double latitud;
    private double longitud;
    //La etiqueta @Temporal permite asignar un tipo de dato a guardar, en este caso almaceno solamente la fecha sin hora.
    @Column(name = "fechaFundacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFundacion;
}
