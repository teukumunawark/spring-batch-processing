package org.spring.batch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sales {
    @Id
    @GeneratedValue
    private Integer id;
    private String region;
    private String country;
    private String itemType;
    private String salesChannel;
    private String orderPriority;
    private String orderDate;
    private Long orderId;
    private String shipDate;
    private Integer unitsSold;
    private Double unitPrice;
    private Double unitCost;
    private Double totalRevenue;
    private Double totalCost;
    private Double totalProfit;
}
