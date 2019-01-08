package cc.rukia.WordAnalyzer.hanPL;

import java.util.List;

public class Word {
     String id;
     String name;
     String summary;
     int fre;
     List<String> refs;
     List<String> relativeWords;
     List<String> policys;
     List<String> news;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getFre() {
        return fre;
    }

    public void setFre(int fre) {
        this.fre = fre;
    }

    public List<String> getRefs() {
        return refs;
    }

    public void setRefs(List<String> refs) {
        this.refs = refs;
    }

    public List<String> getRelativeWords() {
        return relativeWords;
    }

    public void setRelativeWords(List<String> relativeWords) {
        this.relativeWords = relativeWords;
    }

    public List<String> getPolicys() {
        return policys;
    }

    public void setPolicys(List<String> policys) {
        this.policys = policys;
    }

    public List<String> getNews() {
        return news;
    }

    public void setNews(List<String> news) {
        this.news = news;
    }
    public void addNews(String href){
        this.news.add(href);
    }
    public void addPolicy(String href){
        this.policys.add(href);
    }
    public void addRef(String href){
        this.refs.add(href);
    }
}
