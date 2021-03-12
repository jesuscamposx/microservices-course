package jcampos.training.microservices.shoppingservice.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Positive;

import jcampos.training.microservices.shoppingservice.model.Product;

import java.io.Serializable;

@Entity
@Data
@Table(name = "tbl_invoce_items")
public class InvoiceItem  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive(message = "El stock debe ser mayor que cero")
    private Double quantity;
    private Double  price;

    @Column(name = "product_id")
    private Long productId;


    @Transient
    private Double subTotal;
    
    @Transient
    private Product product;


    public Double getSubTotal(){
        if (this.price >0  && this.quantity >0 ){
            return this.quantity * this.price;
        }else {
            return (double) 0;
        }
    }
    public InvoiceItem(){
        this.quantity=(double) 0;
        this.price=(double) 0;

    }
}
