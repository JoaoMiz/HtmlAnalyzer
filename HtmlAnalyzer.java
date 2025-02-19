import java.util.List;
public class HtmlAnalyzer {
    public static void main(String[] args) {

        String url = args[0];
        List<String> linhasHtml = PegarHtml.fetchHtml(url);
        if (linhasHtml == null) {
            System.out.println("URL connection error");
            return;
        }
        String resultado = LogicaHtml.analyzeHtml(linhasHtml);
        System.out.println(resultado);

    }
}