package com.example.EMSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@DynamicInsert
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    @Id
    private int id;
    private String area;
    private String city;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="address")
    @JsonIgnore
    private List<Consumer> consumer;

    public List<Consumer> getConsumer() {
        return consumer;
    }






}
