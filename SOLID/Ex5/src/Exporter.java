public abstract class Exporter {
    /*
     * Contract: export(req) encodes the request content into the format.
     * Precondition: req must not be null.
     * All exporters must accept any non-null ExportRequest and either:
     *   (a) Successfully encode and return result, or
     *   (b) Throw ExportException if the content cannot be encoded for documented format-specific reasons
     * All exporters must handle null fields consistently (treat as empty strings).
     * Postcondition: Returns ExportResult with appropriate contentType or throws ExportException.
     */
    public abstract ExportResult export(ExportRequest req) throws ExportException;

    protected String validateContent(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }
}
