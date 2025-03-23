package com.IPR.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Data
@AllArgsConstructor
@Entity
@Table
@Builder //для DTO паттерна
public class Reactive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;

    //@Column(unique = true)
    private String articul;

    private String vendor;

    private float price;

    private float count;

    @Override
    public String toString() {
        return "Reactive{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", articul='" + articul + '\'' +
                ", vendor='" + vendor + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

    public Reactive(String name, String articul, String vendor, float price, float count) {
        this.name = name;
        this.articul = articul;
        this.vendor = vendor;
        this.price = price;
        this.count = count;
    }

    public Reactive() {
    }


}
