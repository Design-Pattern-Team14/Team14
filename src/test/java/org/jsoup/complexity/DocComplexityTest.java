
package org.jsoup.complexity;

import org.jsoup.nodes.Node;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Evaluator;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeVisitor;
import org.junit.Test;
import org.junit.Before;
import org.jsoup.select.NodeTraversor;

public class DocComplexityTest {
    private Document document;
    private String id;

    @Before
    public void InitTest() {
        Document document = Jsoup.parse(
                "<p>Excl</p><div class=headline><p>Hello</p><p>There</p></div><div class=headline><h1>Headline</h1></div>");
        String id = "asd";
        this.document = document;
        this.id = id;

    }

    @Test
    public void getComplexity() {
        Elements elements = new Elements();
        Evaluator eval = new Evaluator.Id(id);
        NodeTraversor.traverse_mo(new Collector.Accumulator(document, elements, eval), document);

    }

}