package utils;

public enum ProductCategory {
    COMPONENTS("25"),
    CAMERAS("33"),
    TABLETS("57");

    private final String categoryId;

    ProductCategory(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public static ProductCategory fromString(String categoryName) {
        for (ProductCategory category : ProductCategory.values()) {
            if (category.name().equals(categoryName)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Unknown category: " + categoryName);
    }
}
