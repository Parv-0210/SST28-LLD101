public class InvoiceRepository {
    private final FileStore store;

    public InvoiceRepository(FileStore store) {
        this.store = store;
    }

    public void save(String invoiceId, String invoiceContent) {
        store.save(invoiceId, invoiceContent);
    }

    public int getLineCount(String invoiceId) {
        return store.countLines(invoiceId);
    }
}
