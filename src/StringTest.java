public class StringTest {
    public static void main(String[] args) {
        String str = "Hello World!";
        // 문자열 길이 반환
        System.out.println(str.length());

        // 빈 문자열 체크
        System.out.println(str.isEmpty());

        // 문자 찾기
        // -> 0번째 인덱스 문자 반환
        System.out.println(str.charAt(0));
        // -> 특정 문자의 인덱스 반환(가장 첫번째)
        System.out.println(str.indexOf("H"));
        // -> 특정 문자의 인덱스 반환(가장 마지막)
        System.out.println(str.lastIndexOf("H"));

        // 문자열 자르기
        String cutStr = str.substring(0,5);
        System.out.println(cutStr);
        // 인덱스 from 이상, to 미만 위치의 문자열 반환
        String cutStr2 = str.substring(5);
        System.out.println(cutStr2);
        // 인덱스 to 이상(끝까지) 위치의 문자열 반환

        // 문자 치환
        System.out.println(str.replace('H','F'));
        // 기존문자를 바꿀 문자로 치환(전부)
        System.out.println(str.replace("He","Fu"));
        // 정규식/문자열 매칭을 바꿀 문자로 치환
        // 가장 처음 매칭되는 것만 치환
        System.out.println(str.replaceFirst("l","f"));

        // 문자열 비교
        str.equals("Hello world");
        str.compareTo("Hello world");
        // 같은지 비교(equals)

        // 사전순 비교(compareTo)
        // 같으면 0, 앞서면 음수, 뒤면 양수

        // 문자 포함 여부
        str.contains("Hello");

        // 문자열 분리 (String[] 배열 반환)
        String[] strs = str.split(" ");

        // "문자"를 기준으로 문자열을 분리하여 배열로 반환
        char[] arr = str.toCharArray();
        // String -> char[]

        String.valueOf(3);
        Integer.toString(3);
        // char[]형 배열로 변환
        // 예: ['a', 'b', 'c']

        // 숫자 -> 문자열
        // String.valueOf(값)
        // Integer.toString(값)
        // 변경하고자 하는 값이 null인 경우:
        // - String.valueOf(null) 는 "null" 문자열 반환
        // - Integer.toString(null) 는 NPE 발생

        // 문자열 -> 숫자
        Integer.parseInt("3");

        // String[]을 문자열로 출력
        String.join("1","123");
        // 배열의 문자열을 "구분자"로 연결해 출력 (String.join)

        // 대소문자 변환
        // 소문자를 대문자로 변환
        // 대문자를 소문자로 변환

    }
}
