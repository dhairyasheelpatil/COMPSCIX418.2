// This is using an adapater, since we're trying to conform to the clients interface (just calling .getDate on the file 
// regardless of its origin) and a facade since we're trying to provide a unified front to the client and hide internal subsystems

interface FileReader {
    public String getDate(); 
}

class FileReaderImpl implements FileReader {
    File file;
    boolean formatDateISO8601;

    // method overloading to handle different file types
    public FileReaderImpl(File file) {
        this.file = file;
        this.formatDateISO8601 = true;
    }

    public FileReaderImpl(String filePath) {
        this.file = new File(filePath);
        this.formatDateISO8601 = false;  
    }

    // Maybe too many helper functions?
    private String getDateInDays() {
        // assuming the File api has this method
        return this.file.getDays();
    }

    private String getDateInMonths() {
        return this.file.getMonths();
    }

    private String getDateInYears() {
        return this.file.getYear();
    }

    // client doesnt have to know about whether file was passed directly or retrived through memory
    public String getDate() {
        String years = this.getDateInYears();
        String months = this.getDateInMonths();
        String days = this.getDateInDays();
        
        String seperator = this.formatDateISO8601 ? "-" : "/";

        return years + seperator + months + seperator + days
    }
}