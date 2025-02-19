import java.util.*;

public class LogicaHtml {
    public static String analyzeHtml(List<String> linhas) {

    Deque<String> pilha = new ArrayDeque<>();
    Map<Integer, String> deepestText = new HashMap<>();
    int profundidadeMax = 0;

    for (String linha : linhas) {
        if (linha.isEmpty()) continue;

        if (linha.startsWith("<") && linha.endsWith(">") && !linha.startsWith("</")) {
            String tag = linha.substring(1, linha.length() - 1);
            pilha.push(tag);
        }
        else if (linha.startsWith("</") && linha.endsWith(">") && !pilha.isEmpty()) {
            String tag = linha.substring(2, linha.length() - 1);
            if (pilha.peek().equals(tag)) {
                pilha.pop();
            } else {
                return "malformed HTML";
            }
        }
        else {
            int profundidade = pilha.size();
            if (profundidade > profundidadeMax) {
                profundidadeMax = profundidade;
                deepestText.put(profundidade, linha);
            }
        }
    }

        if (!pilha.isEmpty()) return "malformed HTML";
        return deepestText.getOrDefault(profundidadeMax, "");
    }

}
