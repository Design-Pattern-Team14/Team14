package org.jsoup.complexity;

import org.jsoup.nodes.Node;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.jsoup.select.NodeVisitor;
import org.jsoup.select.NodeTraversor;

public class DocComplexity {
    private Document document1;

    DocComplexity(Document document1) {
        this.document1 = document1;
    }

    public void getComplexity(Document document1) {
        Elements elements = new Elements();
        Evaluator eval = new Evaluator.Id("");
        NodeTraversor.traverse_mo(new Collector.Accumulator(document1, elements, eval), document1);

    }

}