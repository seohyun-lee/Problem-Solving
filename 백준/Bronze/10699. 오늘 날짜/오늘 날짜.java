import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        // 날짜 포맷 설정
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // KST 시간대 설정
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        // 현재 KST 날짜 출력
        System.out.println(dateFormat.format(System.currentTimeMillis()));
    }
}
