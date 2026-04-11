package com.example.pos.entities.Suppliers;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * =====================================================
 * Entity: SupplierDirectory
 * Table: supplier_directory
 * =====================================================
 *
 * Auto-generated from schema.json
 */
@Entity
@Table(name = "supplier_directory")
public class SupplierDirectory {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    /**
     * name
     */

    private String name;

    /**
     * contactPerson
     */

    private String contactPerson;

    /**
     * email
     */

    private String email;

    /**
     * phone
     */

    private String phone;

    /**
     * address
     */

    private String address;

    /**
     * status
     */

    private String status;

    /**
     * createdAt
     */

    private LocalDateTime createdAt;

    /**
     * updatedAt
     */

    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
