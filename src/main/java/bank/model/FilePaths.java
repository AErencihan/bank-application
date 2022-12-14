package bank.model;

public enum FilePaths {
    CUSTOMER("ek/Customer.json"),
    ACCOUNT("ek/Account.json");

    private final String path;

    FilePaths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

