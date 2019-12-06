package org.jsoup.facade;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class ForCrawlerJsoupTest {
    ForCrawlerJsoup c;

    @Before
    public void init() {
        // Crawling할 대상 URL 삽입하며 객체 생성
        c = new ForCrawlerJsoup("https://sports.news.naver.com/wfootball/index.nhn");
    }

    @Test
    public void testSelectAndConcreteObject() {
        // select 함수 정상 작동하는지 검사
        // 변경되지 않을 title 부분을 tag로 가져와서 동일한지 assert
        String resultTitle;
        resultTitle = c.selectElement("div.home_news h2").substring(0, 4);
        System.out.println(resultTitle);
        assertEquals("주요뉴스", resultTitle);
    }

    @Test
    public void testSelectsAndAbstractObject() {
        // 변경되는 부분도 올바르게 가져오는지 검사위해 not null 인지만 봄
        // selectElements도 올바르게 작동하는지 확인
        //
        String resultArticle;
        resultArticle = c.selectElements("li");
        assertNotNull(resultArticle);
    }

    @Test
    public void testSelectAndConcreteArrayListObject() {
        // select 함수 정상 작동하는지 검사
        // 변경되지 않을 title 부분을 tag로 가져와서 동일한지 assert
        ArrayList<String> resultArticleArrayList;
        resultArticleArrayList = c.selectElementsArrayList("li");
        assertNotNull(resultArticleArrayList);
    }

    @Test
    public void testReSelectObject() {
        // reselect 함수 정상 작동하는지 검사
        // 변경되는 부분도 올바르게 가져오는지 검사위해 not null 인지만 봄
        String resultReTitle;
        c.selectElement("div.home_news");
        resultReTitle = c.reSelectElement("h2").substring(0, 4);
        System.out.println(resultReTitle);
        assertEquals("주요뉴스", resultReTitle);
    }

    @Test
    public void testSetandCheckTempElement() {
        // 사용할 일이 없지만 혹여 올바른 속성을 가져 오지 못하거나 Element를 set할 때 필요
        c.setTempElement("div.home_news h2");
        assertNotNull(c.checkTempElement().substring(0, 4));
    }

}