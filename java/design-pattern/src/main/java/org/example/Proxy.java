package org.example;

/**
 * 代理模式
 */
public @interface Proxy {
    /**
     * 抽象主题-http请求
     */
    interface Http {
        void send();
    }

    /**
     * 具体主题-客户端
     */
    class Client implements Http {
        @Override
        public void send() {
            System.out.println("Client.send");
        }

        public void accept() {
            System.out.println("Client.accept");
        }
    }

    /**
     * 代理类-静态代理
     */
    class StaticProxy implements Http {
        private final Http client = new Client();

        @Override
        public void send() {
            System.out.println("StaticProxy");
            client.send();
            System.out.println("StaticProxy");
        }
    }

    /**
     * 代理类-动态代理
     */
    class DynamicProxy {
        public static Http getProxy(Http client) {
            Class<? extends Http> clazz = client.getClass();
            return (Http) java.lang.reflect.Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), (proxy, method, args) -> {
                System.out.println("DynamicProxy");
                Object result = method.invoke(client, args);
                System.out.println("DynamicProxy");
                return result;
            });
        }
    }
}
