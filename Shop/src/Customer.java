class Customer implements DiscountRate {
    private String customerName;
    private String customerType;

    public Customer(String customerName, String customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public double getServiceMemberDiscount() {
        switch (customerType.toLowerCase()) {
            case "premium" -> {
                return 0.2;
            }
            case "gold" -> {
                return 0.15;
            }
            case "silver" -> {
                return 0.1;
            }
            default -> {
                return 0.0;
            }
        }
    }

    @Override
    public double getProductMemberDiscount() {
        switch (customerType.toLowerCase()) {
            case "premium", "gold", "silver" -> {
                return 0.1;
            }
            default -> {
                return 0.0;
            }
        }
    }
}
