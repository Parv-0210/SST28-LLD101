import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    private static final int MAX_CONTENT_LENGTH = 20;

    @Override
    public ExportResult export(ExportRequest req) throws ExportException {
        if (req == null) {
            throw new ExportException("request cannot be null");
        }

        String body = validateContent(req.body);
        
        if (body.length() > MAX_CONTENT_LENGTH) {
            throw new ExportException("PDF cannot handle content > 20 chars");
        }

        String fakePdf = "PDF(" + validateContent(req.title) + "):" + body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
