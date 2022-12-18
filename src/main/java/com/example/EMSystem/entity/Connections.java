package com.example.EMSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@DynamicInsert
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Connections  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int oldReading;
    private String addedOn;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "consumerId")
    @JsonIgnore
    private Consumer consumer;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "connectionTypeId")
    @JsonIgnore
    private ConnectionType connectionType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="connections")
    @JsonIgnore
    private List<Bill> bill;



}
