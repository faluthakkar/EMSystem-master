package com.example.EMSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Data
@ToString
@NamedStoredProcedureQuery(name = "billsOfAllConsumers", procedureName = "billsOfAllConsumers", resultClasses = Bill.class)
@NamedStoredProcedureQuery(name="generateBillByConnectionId", procedureName = "generateBillByConnectionId",parameters= {
        @StoredProcedureParameter(mode= ParameterMode.IN,name="inputId",type=Integer.class),
        @StoredProcedureParameter(mode= ParameterMode.IN,name="currentReading",type=Integer.class)
},resultClasses=Bill.class)

@NamedStoredProcedureQuery(name="billsByMonthAndYear", procedureName = "billsByMonthAndYear",parameters= {
        @StoredProcedureParameter(mode= ParameterMode.IN,name="iyear",type=String.class),
        @StoredProcedureParameter(mode= ParameterMode.IN,name="imonth",type=String.class)
},resultClasses=Bill.class)

@NamedStoredProcedureQuery(name="billsByCityAndArea", procedureName = "billsByCityAndArea",parameters= {
        @StoredProcedureParameter(mode= ParameterMode.IN,name="iarea",type=String.class),
        @StoredProcedureParameter(mode= ParameterMode.IN,name="icity",type=String.class)
},resultClasses=Bill.class)
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dateTime;
    private int oldReading;
    private int newReading;
    private int billedUnits;
    private double totalAmount;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "consumerId")
    private Consumer consumer;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "connectionId")
    //@JsonIgnore
    private Connections connections;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "connectionTypeId")
    private ConnectionType connectionType;




}
