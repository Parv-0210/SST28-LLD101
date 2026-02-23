import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) throws ExportException {
        if (req == null) {
            throw new ExportException("request cannot be null");
        }

        String title = validateContent(req.title);
        String body = validateContent(req.body);

        // Escape CSV fields: quote if they contain special characters, escape quotes
        String escapedTitle = escapeCsv(title);
        String escapedBody = escapeCsv(body);

        String csv = "title,body\n" + escapedTitle + "," + escapedBody + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    private String escapeCsv(String s) {
        if (s == null) {
            return "";
        }
        // If field contains comma, newline, or quote, wrap in quotes and escape quotes
        if (s.contains(",") || s.contains("\n") || s.contains("\"")) {
            return "\"" + s.replace("\"", "\"\"") + "\"";
        }
        return s;
    }
}
