package base;

/**
 * 关于不可变对象的测试
 */
public class FinalTest {

    static class finalTestClass {
        private final String id;
        private final String username;
        private final String nickname;

        public finalTestClass(String id, String username, String nickname) {
            this.id = id;
            this.username = username;
            this.nickname = nickname;
        }
    }
}
