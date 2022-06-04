package algorithm;

public class Article {
    private final String articleTitle;
    private final String articleText;

    public Article(String articleTitle, String articleText){
        this.articleTitle = articleTitle;
        this.articleText = articleText;
    }

    public String getArticleTitle(){
        return articleTitle;
    }

    public String getArticleText(){
        return articleText;
    }
}
