package core.elements;

import java.util.Optional;

public class Product extends BaseElement {
    private String name;
    private double price;
    private Optional<String> productCode;
    private Optional<String> brand;
    private Optional<String> availability;

    private Product(ProductBuilder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.productCode = builder.productCode;
        this.brand = builder.brand;
        this.availability = builder.availability;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Optional<String> getProductCode() {
        return productCode;
    }

    public void setProductCode(Optional<String> productCode) {
        this.productCode = productCode;
    }

    public Optional<String> getBrand() {
        return brand;
    }

    public void setBrand(Optional<String> brand) {
        this.brand = brand;
    }

    public Optional<String> getAvailability() {
        return availability;
    }

    public void setAvailability(Optional<String> availability) {
        this.availability = availability;
    }

    public static class ProductBuilder {
        private String name;
        private double price;
        private Optional<String> productCode = Optional.empty();
        private Optional<String> brand = Optional.empty();
        private Optional<String> availability = Optional.empty();

        public ProductBuilder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public ProductBuilder withProductCode(String productCode) {
            this.productCode = Optional.ofNullable(productCode);
            return this;
        }

        public ProductBuilder withBrand(String brand) {
            this.brand = Optional.ofNullable(brand);
            return this;
        }

        public ProductBuilder withAvailability(String availability) {
            this.availability = Optional.ofNullable(availability);
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
