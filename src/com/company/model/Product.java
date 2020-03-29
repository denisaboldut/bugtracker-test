package com.company.model;

import com.company.repository.ProductRepository;

public class Product {
    private int idproduct;
    private String denumire;
    private String data_lansarii;
    private String descriere;

    Product(int idproduct, String denumire, String data_lansarii, String descriere) {
        this.idproduct = idproduct;
        this.denumire = denumire;
        this.data_lansarii = data_lansarii;
        this.descriere = descriere;


        new ProductRepository().createProduct(this);
    }

    public int getIdproduct() {
        return idproduct;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getData_lansarii() {
        return data_lansarii;
    }

    public String getDescriere() {
        return descriere;
    }

    public boolean updateProduct(String denumire, String data_lansare, String descriere, Product product){
        boolean updatedProduct = new ProductRepository().updateProduct(denumire, data_lansare, descriere, product);

        return updatedProduct;
    }

    public boolean deleteProduct(int idP){
        boolean productDeleted = new ProductRepository().deleteProduct(idP);

        return productDeleted;
    }


}
