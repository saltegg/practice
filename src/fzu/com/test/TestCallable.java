package fzu.com.test;

import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        return null;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable();
        TestCallable t2 = new TestCallable();
        TestCallable t3 = new TestCallable();

        // 创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(1);

        // 提交执行
        Future<Boolean> r1 = service.submit(t1);
        Future<Boolean> r2 = service.submit(t2);
        Future<Boolean> r3 = service.submit(t3);

        // 获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        service.shutdown();
    }
}
