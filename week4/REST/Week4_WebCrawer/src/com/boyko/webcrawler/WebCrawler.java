package com.boyko.webcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    public Stack<String> stack = new Stack<>();
    public Set<String> unique = new HashSet<>();

    public String getWebContent(URL url) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
        StringBuilder webContent = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            webContent.append(inputLine + "\n");
        in.close();
        return webContent.toString();
    }

    public String crawl(URL Url, String searchedWord) throws Exception {
        String webContent = getWebContent(Url);
        if (webContent.contains(searchedWord))
            return Url.toString() + " " + searchedWord;
        for (String url : getAllLinks(Url, webContent.toString())) {
            if (!unique.contains(url) && url.contains(Url.toString())) {
                unique.add(url);
                stack.push(url);
            }
        }
        return crawl(new URL(stack.pop()), searchedWord);
    }

    private List<String> getAllLinks(URL website, String content) throws MalformedURLException {
        List<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String urls = matcher.group(1);
            resultList.add(normalizeLinks(website, urls));
        }
        return resultList;
    }

    private String normalizeLinks(URL website, String url) throws MalformedURLException {
        URL fullPath = new URL(website, url);
        return !url.contains("https") && !url.contains("http") && !url.contains("..") ? fullPath.toString() : url;
    }

    public static void main(String[] args) throws Exception {
        WebCrawler webcrawler = new WebCrawler();
        System.out.println(webcrawler.crawl(new URL("http://ebusiness.free.bg/"), "Револвираща"));
    }
}
