package com.diviso.graeshoppe.report.service.dto;
import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.diviso.graeshoppe.report.domain.Sale} entity.
 */
public class SaleDTO implements Serializable {

    private Long id;

    private String storeName;

    private Long storePhone;

    private String storeidpcode;

    private Long customerId;

    private Instant date;

    private Double grandTotal;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(Long storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreidpcode() {
        return storeidpcode;
    }

    public void setStoreidpcode(String storeidpcode) {
        this.storeidpcode = storeidpcode;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SaleDTO saleDTO = (SaleDTO) o;
        if (saleDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), saleDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SaleDTO{" +
            "id=" + getId() +
            ", storeName='" + getStoreName() + "'" +
            ", storePhone=" + getStorePhone() +
            ", storeidpcode='" + getStoreidpcode() + "'" +
            ", customerId=" + getCustomerId() +
            ", date='" + getDate() + "'" +
            ", grandTotal=" + getGrandTotal() +
            "}";
    }
}
