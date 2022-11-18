一、基础知识
#👉 1、什么是线程和进程？
# 什么是进程？
程序由指令和数据组成，但是这些指令要运行，数据要读写，就必须将指令加载到cpu，数据加载至内存。在指令运行过程中还需要用到磁盘，网络等设备，进程就是用来加载指令管理内存管理IO的。
进程是指在系统中正在运行的一个应用程序，程序一旦运行就是进程。比如.exe文件运行，进程就可以视为程序的一个实例，大部分程序都可以运行多个实例进程

总结：进程是把指令加载给CPU，数据加载到内存并执行的程序实例

# 进程的特点：
1、每个进程可以包括多个线程
2、每个进程都有自己独立的内存空间，而其内部的线程可以共享这些内存空间，进程上下文切换的开销比较大，不同进程之间不共享内存

# 什么是线程？
线程是进程的一个子集，一个线程就是一个指令流的执行，线程按照一定的顺序把这些指令流交给CPU执行，就是线程的执行

# 区别与联系？
线程是进程的子集，一个进程可以有很多线程，每条线程并行执行不同的任务。
不同的进程使用不同的内存空间，而线程共享同一进程的内存空间。别把它和栈内存搞混，每个线程都拥有单独的栈内存用来存储本地数据。
线程作为操作系统能够进行运算调度的最小单位，进程作为资源分配的最小单位。
线程更轻量，线程上下文切换成本一般上要比进程上下文切换低

#👉 2、什么是并行与并发？
并发：操作系统的任务调度器调度多个线程轮流使用某个CPU的操作（CPU的时间片为15ms），这个过程中会发生线程的上下文切换
![并发](/src/main/javaInterview/picture/java基础_并发.png)

并行：对于多核CPU来讲，每个核（core） 都可以调度运行线程，这时候线程可以是并行的，不同的线程同时使用不同的cpu在执行。
![并发](/src/main/javaInterview/picture/java基础_并行.png)

一般来说对于单核CPU的机器，线程执行是并发的，对于多核CPU来讲，线程执行是既有并行也有并发的

#👉 3、什么是同步执行和异步执行
以调用方的角度讲，如果需要等待结果返回才能继续运行的话就是同步，如果不需要等待就是异步
也就是说一个程序需要运行完了有结果了才能进行下一个线程，这样这个程序就会堵塞其他的程序，这就是同步，异步就是这个程序在运行的时候我仍然可以不管他运行别的程序
多线程可以将同步程序变为异步的，从而增加系统资源的利用率
比如说读取磁盘文件时，假设读取操作花费了5秒，如果没有线程的调度机制，这么cpu只能等5秒，啥都不能做。

#👉 4、Java中实现多线程有几种方法？（较难）
Thread的构造方法参数可以传入Runnable接口和FutureTask对象
Runnable缺少的一项功能是，当线程终止时（即run（）完成时），我们无法使线程返回结果。为了支持此功能，Java中提供了Callable接口。

# 继承Thread类
（1）定义Thread类的子类，并重写该类的run方法，该run方法的方法体就代表了线程要完成的任务。因此把run()方法称为执行体。
（2）创建Thread子类的实例，即创建了线程对象。
（3）调用线程对象的start()方法来启动该线程。
public class MyThread extends Thread {
public void run() {
System.out.println("MyThread.run()");
}
}
MyThread myThread1 = new MyThread();
myThread1.start();

# 实现runable接口
（1）定义runnable接口的实现类，并重写该接口的run()方法，该run()方法的方法体同样是该线程的线程执行体。
（2）创建 Runnable实现类的实例，并依此实例作为Thread的target来创建Thread对象，该Thread对象才是真正的线程对象。
（3）调用线程对象的start()方法来启动该线程

public class MyThread extends OtherClass implements Runnable {
public void run() {
System.out.println("MyThread.run()");
}
}

启动 MyThread，需要首先实例化一个 Thread，并传入自己的 MyThread 实例：

MyThread myThread = new MyThread();
Thread thread = new Thread(myThread);
thread.start();
//事实上，当传入一个 Runnable target 参数给 Thread 后， Thread 的 run()方法就会调用 target.run() public void run() { if (target != null) { target.run(); } }

# 实现Callable接口（创建FutureTask(Callable)对象）
（1）创建Callable接口的实现类，并实现call()方法，该call()方法将作为线程执行体，并且有返回值。
（2）创建Callable实现类的实例，使用FutureTask类来包装Callable对象，该FutureTask对象封装了该Callable对象的call()方法的返回值。
（3）使用FutureTask对象作为Thread对象的target创建并启动新线程。
（4）调用FutureTask对象的get()方法来获得子线程执行结束后的返回值

public class SomeCallable<V> extends OtherClass implements Callable<V> {
@Override
public V call() throws Exception {
// TODO Auto-generated method stub
return null;
}
}
Callable<V> oneCallable = new SomeCallable<V>();   
//由Callable<Integer>创建一个FutureTask<Integer>对象：   
FutureTask<V> oneTask = new FutureTask<V>(oneCallable);   
//注释：FutureTask<Integer>是一个包装器，它通过接受Callable<Integer>来创建，它同时实现了Future和Runnable接口。
//由FutureTask<Integer>创建一个Thread对象：   
Thread oneThread = new Thread(oneTask);   
oneThread.start();   
//至此，一个线程就创建完成了。

#👉 5、Future接口，Callable接口，FutureTask实现类的关系
Callable接口中就一个抽象方法call()，有返回值
Future接口中定义了关于线程状态的方法，比如打断线程执行的cancel方法，判断该线程是否被取消的isCancelled()方法，返回线程是否执行完的isDone方法，以及重要的get方法获取返回值
FutureTask实现类实现了Future接口，并且有构造函数，参数是传入一个Callable接口，
以此获得返回值
其中Future接口的get方法是阻塞方法，没有得到get的值会阻塞主线程

    package TestFutureTask;
    import java.util.concurrent.ExecutionException;
    import java.util.concurrent.FutureTask;

    public class TestMain {
        public static void main(String[] args) {
            FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
                System.out.println("futureTask开始了");
                Thread.sleep(10000);
                return 100;
            }
            );
            Thread thread = new Thread(futureTask, "thread1");
            thread.start();
            try {
                System.out.println(futureTask.get());//会阻塞主线程使得主线程不能立刻输出语句
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("主线程运行！");
        }
    }

#👉 6、什么是Callable和Future?
Callable 接口类似于 Runnable，从名字就可以看出来了，但是 Runnable 不会返 回结果，并且无法抛出返回结果的异常，
而 Callable 功能更强大一些，被线程执 行后，可以返回值，这个返回值可以被 Future 拿到，也就是说，Future 可以拿到 异步执行任务的返回值。可以认为是带有回调的 Runnable。
Future 接口表示异步任务，是还没有完成的任务给出的未来结果。所以说 Callable用于产生结果，Future 用于获取结果
Futuretask类通过传入一个Callable接口创建一个有返回值的线程任务，并且其实现了Future接口，可以通过其get方法拿到这个结果

#👉 7、什么是线程的上下文切换？
多线程的上下文切换是指 CPU 控制权由一个已经正在运行的线程切换到另外一个就绪并等待获取 CPU 执行权的线程的过程。

可能有以下原因：
（1）线程的 cpu 时间片用完(每个线程轮流执行，看前面并发的概念)
（2）垃圾回收
（3）有更高优先级的线程需要运行
（4）线程自己调用了 sleep、yield、wait、join、park、synchronized、lock 等方法

当 Context Switch 发生时，需要由操作系统保存当前线程的状态，并恢复另一个线程的状态

#👉 8、Thread类中的start()和run()方法有什么区别？
start方法是线程从就绪变为启动状态的方法，而run方法是线程启动之后需要执行的代码，如果直接调用run方法，相当于使用thread对象调用它的一个普通方法而已，调用者是线程对象，并且是在主线程中执行的。

而start方法可以使得线程启动，之后再调用run方法便是在该线程中执行

#👉 9、Java中interrupted和isInterruptedd方法的区别？
一个清除一个不清除中断标记

interrupted() 不仅返回当前Thread的中断状态，而且会清除当前Thread的中断状态**。所以如果当前Thread.interrupted()返回中断true，紧接着再call一次interrupted() 会返回“非中断false”，因为中断状态在第一次call的时候清除了。(源码中进行了操作)静态方法
isInterrupted() 也会返回当前Thread的中断状态，但是==不会主动清除当前Thread的中断状态==。

#👉 10、为何stop()和suspend()方法不推荐使用
用Thread.stop()方法来终止线程将会释放该线程对象已经锁定的所有监视器。
如果以前受这些监视器保护的任何对象都处于不连贯状态，那么损坏的对象对其他线程可见，这有可能导致不安全的操作。

suspend()方法 该方法已经遭到反对，因为它具有固有的死锁倾向。调用suspend（）方法的时候，目标线程会停下来，并且不会释放锁资源，在目标线程重新开始以前，其他线程都不能访问该资源。
除非被挂起的线程恢复运行。对任何其他线程来说，如果想恢复目标线程，同时又试图使用任何一个锁定的资源，就会造成死锁。

#👉 11、如何停止一个正在运行的线程？（重要）
##1、使用stop()来停止线程：stop()方法让线程立即停止运行, 这种暴力停止可能会破坏线程业务的原子性，**不推荐使用**
##2、使用interrupt产生打断标志位来停止线程
（1）捕捉打断标记并且直接return
由于run方法是一个void方法，可以在线程运行的时候用interrupt方法进行打断，此时产生一个打断标记位，捕捉到该标记位之后便可以优雅地结束该线程（可以直接return，也可以进行一些操作后return;）

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 500000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("线程终止, 停止for循环.");
                    return;
                }
                System.out.println("i=" + (i + 1));
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        try {
            Thread.sleep(200);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

（2）捕捉打断标记，并且抛出异常终止程序
捕捉到标记位之后，扔出异常来停止该线程，需要使用throw new Exception来打断

    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100000; i++) {
                    if (this.isInterrupted()) {
                        System.out.println("线程终止, 停止for循环.");
                        throw new InterruptedException();
                    }
                    System.out.println("i=" + (i + 1));
                }
            } catch (InterruptedException e) {
                System.out.println("MyThread抛出InterruptedException.");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        try {
            Thread.sleep(200);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

（3）当线程处于sleep,park,join,wait的时候需要在catch块处理异常时自行设置打断标记
当线程处于正常状态的时候，打断会产生打断的标记位，但是在线程处于sleep,join,wait,park等状态时，被打断将不会产生标记位，
我们可以使用trycatch块来处理该情况，当程序被打断时，在程序catch并处理打断异常时候可以自己添加打断标记，从而设置打断标记。（两阶段终止模式）
注：若程序是while循环，那么在捕捉到打断标记时，也可以用break结束循环从而结束线程

    @Slf4j
    public class Test11 {
        public static void main(String[] args) throws InterruptedException {
            TwoParseTermination twoParseTermination = new TwoParseTermination();
            twoParseTermination.start();
            Thread.sleep(3000);  // 让监控线程执行一会儿
            twoParseTermination.stop(); // 停止监控线程
        }
    }

    @Slf4j
    class TwoParseTermination{
        Thread thread ;
        public void start(){
            thread = new Thread(()->{
                while(true){
                    if (Thread.currentThread().isInterrupted()){
                        log.debug("线程结束。。正在料理后事中");
                        break;
                    }
                    try {
                        Thread.sleep(500);
                        log.debug("正在执行监控的功能");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
        public void stop(){
            thread.interrupt();
        }
    }

#👉 12、sleep和yield的区别？
##状态的区别：
调用 sleep 会让当前线程从 Running 进入 Timed Waiting 状态（阻塞）
调用 yield 会让当前线程从 Running 进入 Runnable 就绪状态，然后调度执行其它线程

##调度的区别：
调用sleep之后，该线程将进入阻塞状态，分不到CPU的时间片
调用yield之后，该线程会让出CPU的使用权，但是任务调度器仍然可能分配给该线程时间片，从宏观上只是该线程被分配CPu的概率变低了
