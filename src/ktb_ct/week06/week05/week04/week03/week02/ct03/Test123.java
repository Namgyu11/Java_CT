package ktb_ct.week06.week05.week04.week03.week02.ct03;

public class Test123 {

    public static void main(String[] args) {
        String a = "http://k.kakaocdn.net/dn/1bZGz/btqC5QJ1Q7v/1k3KQkKQ";
        String b = "https://image1.kakaocdn.net/dn/1bZGz/btqC5QJ1Q7v/1k3KQkKQ";

        System.out.println(getProfileImageUrl(a));
        System.out.println(getProfileImageUrl(b));
    }

    //  카카오에서 이미지를 받아오면 https://k.kakaocdn.net 형식만 받아온다.
    // 나머지 형식이면 null로 받아온다.
    private static String getProfileImageUrl(String imagePath) {
        if (imagePath != null && imagePath.contains("k.kakaocdn.net")) {
            return imagePath;
        }
        return null;
    }
}
