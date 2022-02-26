package thread;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.strands.SuspendableCallable;
import com.code.utils.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @name: FiberEasyUseTest
 * @author: mubai.
 * @date: 2022/2/11
 * @version: 1.0
 * @description: Fiber协程简单验证
 */
public class FiberEasyUseTest {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(20);
        for (int i = 1; i <= 20; i++) {
            integers.add(i);
        }
        //将目标数组平均分成5组
        List<List<Integer>> averageIntegers = ListUtil.averageAssign(integers, 5);
        //定义Fiber协程处理集合
        List<Fiber<Long>> resultFibers = new ArrayList<>();
        //定义Fiber协程业务代码
        averageIntegers.forEach(item -> {
            if (!item.isEmpty()) {
                Fiber<Long> result = new Fiber<>((SuspendableCallable<Long>) () -> item.stream().mapToLong(Integer::intValue).sum()).start();
                resultFibers.add(result);
            }
        });
        //打印结果
        AtomicLong finalResult = new AtomicLong(0L);
        resultFibers.forEach(item -> {
            try {
                System.out.println(item.get());
                finalResult.addAndGet(item.get());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        Long baseResult = 0L;
        for (Integer integer : integers) {
            baseResult += integer;
        }
        System.out.println("单线程数据统计结果：" + finalResult.get());
        System.out.println(baseResult);
    }
}
