import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class ForCrawlerJsoup {
    private String url;
    private String option;

    // reselect하는 경우를 위해 user가 select할 때마다 element형으로 갖고 있음
    private Elements tempElement;

    Document doc = null;

    // 객체를 생성함과 동시에 Doc 트리 생성 -> 아래 함수로 select 접근
    public ForCrawlerJsoup(String url) {
        this.url = url;

        try {
            doc = Jsoup.connect(url).userAgent(
                    "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36")
                    .header("scheme", "https")
                    .header("accept",
                            "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("accept-encoding", "gzip, deflate, br")
                    .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6")
                    .header("cache-control", "no-cache").header("pragma", "no-cache")
                    .header("upgrade-insecure-requests", "1").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 첫 Select의 경우
    // element 하나만
    public String selectElement(String tags) {
        tempElement = doc.select(tags);
        String element = tempElement.toString();

        return element;
    }

    // elements의 경우 ','로 이어붙여서 단일 String 반환
    public String selectElements(String tags) {
        tempElement = doc.select(tags);
        String resultElements = new String();

        for (Element el : tempElement) {
            if (resultElements.isEmpty())
                resultElements = el.toString();

            resultElements = resultElements.concat("," + el.toString());
        }
        return resultElements;
    }

    // elements의 경우 ArrayList형 반환
    public ArrayList<String> selectElementsArrayList(String tags) {
        tempElement = doc.select(tags);
        ArrayList<String> resultElements = new ArrayList<String>();

        for (Element el : tempElement) {
            resultElements.add(el.toString());
        }
        return resultElements;
    }

    // 다시 한 번 Select 하는 경우
    // element 하나만
    public String reSelectElement(String tags) {
        String resultElement = new String();
        tempElement = tempElement.select(tags);

        resultElement = tempElement.toString();

        return resultElement;
    }

    // elements의 경우 ','로 이어붙여서 단일 String 반환
    public String reSelectElements(String tags) {
        String resultElements = new String();
        tempElement = tempElement.select(tags);

        for (Element el : tempElement) {
            if (resultElements.isEmpty())
                resultElements = el.toString();

            resultElements = resultElements.concat("," + el.toString());
        }
        return resultElements;
    }

    // elements의 경우 ArrayList형 반환
    public ArrayList<String> reSelectElementsArrayList(String tags) {
        tempElement = doc.select(tags);
        ArrayList<String> resultElements = new ArrayList<String>();

        for (Element el : tempElement) {
            resultElements.add(el.toString());
        }
        return resultElements;
    }

    // 현재의 tempElement check (For reselect)
    public String checkTempElement() {
        return tempElement.toString();
    }

    // tmepElement를 직접 setting
    public void setTempElement(String tags) {
        tempElement = doc.select(tags);
    }
}
