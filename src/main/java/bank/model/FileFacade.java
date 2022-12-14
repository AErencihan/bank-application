package bank.model;

import java.io.File;

public enum FileFacade {
    CUSTOMER(new File(FilePaths.CUSTOMER.getPath())),
    ACCOUNT(new File(FilePaths.ACCOUNT.name()));

    private final File file;

    FileFacade(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }
}
