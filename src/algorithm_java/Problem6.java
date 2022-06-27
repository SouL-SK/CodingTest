package algorithm_java;/*
    문제 6 : 게시물 등록을 할 수 있는 명령어와 등록한 게시물을 조회할 수 있는 명령어를 가진 프로그램을 만드세요.
        명령어 형태는 아래와 같습니다. 명령어) 수행할 명령 (등록 or 조회) 입력

    풀이 과정 >
      - 명령어의 추가나 변경 작업은 적고, 명령어를 바로 처리해야 하기 때문에 BufferedReader 보단 Scanner 클래스로 대체
      - 조회, 목록 을 조회 명령으로 인식하는 것을 토대로 등록, 추가 등의 단어를 추가로 삽입하여 등록 커맨드로 인식하도록 설계
      - 명령어는 변하지 않고, 명령어가 변경되는 일은 없으니 StringBuilder 보다는 String 객체를 사용하기로 결정
      - 글이 저장되면 글 번호와 제목이 나오고, 제목과 내용을 같이 저장. 글 번호는 중복이 안되기 때문에 key 값으로 생각한다.
        즉, HashMap을 사용하기로 결정. 글은 따로 클래스 객체를 만들기로 결정.
 */
import java.util.HashMap;
import java.util.Scanner;

public class Problem6 {
    static int articleCount = 0;
    public static void main(String[] args){

        // object declaration
        // initialize command keywords.
        String[] createArticle = new String[] {"등록", "추가", "생성", "글쓰기", "업로드"};
        String[] readArtcle = new String[] {"목록", "조회", "리스트", "테이블", "읽기"};
        String[] exitSystem = new String[] {"종료", "로그아웃", "셧다운", "파워오프"};
        HashMap<Integer, Article> articleList = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        // variable declaration
        String cmdStr = null;

        // article. gettitle

        // input command line
        do {
            try{
                System.out.print("명령어) ");
                cmdStr = sc.next();

                // check create command
                if(checkCommand(cmdStr, createArticle)){
                    System.out.print("제목: ");
                    String articleTitle = sc.next();
                    System.out.print("내용 : ");
                    String articleText = sc.next();
                    if (articleUpload(articleTitle, articleText, articleList)){
                        System.out.println("[알림] "+(articleList.size())+"번글이 등록되었습니다.");
                    }
                }
                // check read command
                if (checkCommand(cmdStr, readArtcle)){
                    System.out.print("번호 / 제목\n-------------------\n");
                    for(Integer i : articleList.keySet()){
                        System.out.print(i+" / "+articleList.get(i).getArticleTitle()+"\n");
                    }
                }
            }catch(Exception e){}
        }
        //check exit command
        while (!checkCommand(cmdStr, exitSystem));
        System.out.println("프로그램을 종료합니다.");
    }

    /**
     * check if the command line is valid
     * @param commandString command line to check
     * @return command line is correct or not
     */
    static boolean checkCommand(String commandString, String[] commandKeyList){
        for (String s : commandKeyList) {
            if (commandString.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * upload article to HashSet
     * @param articletitle article title
     * @param articleText article content
     * @return upload is success or not
     */
    static boolean articleUpload(String articletitle, String articleText, HashMap<Integer, Article> hashList){
        hashList.put(articleCount, new Article(articletitle, articleText));
        articleCount++;
        return true;
    }
}
