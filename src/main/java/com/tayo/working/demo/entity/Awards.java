package com.tayo.working.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "Awards")
public class Awards implements Serializable {

    @Column (name = "ID", nullable = false, length = 10)
    @Id
    private Long id;

    @Column (name = "awardName")
    @NotBlank(message = "Enter the award name")

    public String awardName;

    @Column (name = "Category")
    @NotBlank(message = "Enter the category")

    public String category;


    public Awards(){}

    public Awards(Long id, @NotBlank(message = "Enter the award name") String awardName, @NotBlank(message = "Enter the category") String category) {
        this.id = id;
        this.awardName = awardName;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Awards{" +
                "id=" + id +
                ", awardName='" + awardName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
